package org.itstep;

import java.util.logging.Logger;

import org.itstep.entity.ConnectionEntity;
import org.itstep.entity.MySimpleObject;
import org.itstep.service.FileManagerService;
import org.itstep.util.Randomizer;

public class ApplicationRunner {
	
	private static Logger logger = Logger.getLogger(ApplicationRunner.class.getName()); 

	public static void main(String[] args) {
//		MySimpleObject myObject = new MySimpleObject("test text field", 12345, true);
//		FileManagerService.writeObjectToFile(myObject);
//		
//		MySimpleObject objectFromFile = FileManagerService.readObjectFromFile();
//		logger.info("My object is\n" + objectFromFile.toString());
		
//		FileManagerService.copyFile("photo.jpg", "path.jpg");
		
		Long time = System.currentTimeMillis();
		Integer sessionId = Randomizer.getNumber(10000000, 99999999);
		String IP = Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255);
		
		ConnectionEntity connectionEntity = new ConnectionEntity(time, sessionId, IP);
		FileManagerService.writeTextToFile(connectionEntity.toString(), true);
	}

}
