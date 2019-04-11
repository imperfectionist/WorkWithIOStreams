package org.itstep.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.itstep.entity.ConnectionEntity;
import org.itstep.entity.MySimpleObject;

public class FileManagerService {

	private final static String SERIALIZABLE_FILE_PATH = System.getProperty("user.dir")
			+ System.getProperty("file.separator") + "files" + System.getProperty("file.separator") + "my_object.obj";

	private final static String DIR_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator");

	private final static String TEXT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator") + "test.txt";

	// Serialization
	public static void writeObjectToFile(MySimpleObject myObject) {

		try (FileOutputStream fos = new FileOutputStream(SERIALIZABLE_FILE_PATH);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(myObject);
			oos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MySimpleObject readObjectFromFile() {
		MySimpleObject myObject = null;

		try (FileInputStream fis = new FileInputStream(SERIALIZABLE_FILE_PATH);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			myObject = (MySimpleObject) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return myObject;
	}

	// Bytes
	private static byte[] readBytesFromFile(String fileName) {
		String filePath = DIR_PATH + fileName;
		byte[] bytes = null;

		try {
			bytes = Files.readAllBytes(new File(filePath).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;
	}

	private static void writeBytesToDir(String fileName, byte[] bytes) {

		try (FileOutputStream fos = new FileOutputStream(DIR_PATH + fileName)) {

			fos.write(bytes);
			fos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void copyFile(String original, String copy) {
		byte[] bytes = readBytesFromFile(original);
		writeBytesToDir(copy, bytes);
	}

	// Text
	public static void writeTextToFile(String text, boolean append) {
		try (FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append)) {
			fileWriter.write(text + "\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<ConnectionEntity> readConnectionInfoFromFile() {
		List<ConnectionEntity> connectionEntities = new ArrayList<ConnectionEntity>();

		try (FileReader fileReader = new FileReader(TEXT_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				Long time = Long.parseLong(words[0]);
				Integer sessionId = Integer.parseUnsignedInt(words[1]);
				String iPAddress = words[2];
				ConnectionEntity connectionEntity = new ConnectionEntity(time, sessionId, iPAddress);
				connectionEntities.add(connectionEntity);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return connectionEntities;
	}

}
