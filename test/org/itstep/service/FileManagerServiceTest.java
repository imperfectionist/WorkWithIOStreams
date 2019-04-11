package org.itstep.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.entity.ConnectionEntity;
import org.itstep.util.Randomizer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileManagerServiceTest {

	private static List<ConnectionEntity> connectionEntities = new ArrayList<ConnectionEntity>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		connectionEntities = FileManagerService.readConnectionInfoFromFile();
	}


	@Test
	void testReadAndWriteConnectionInfo() {
		Long time = System.currentTimeMillis();
		Integer sessionId = Randomizer.getNumber(10000000, 99999999);
		String iPAddress = Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255) + "." +
					Randomizer.getNumber(1, 255);
		
		ConnectionEntity testConnectionEntity = new ConnectionEntity(time, sessionId, iPAddress);
		FileManagerService.writeTextToFile(testConnectionEntity.toString(), false);
		
		List<ConnectionEntity> testConnectionEntities = FileManagerService.readConnectionInfoFromFile();
		assertNotNull(testConnectionEntities);
		assertEquals(1, testConnectionEntities.size());
		assertEquals(iPAddress, testConnectionEntities.get(0).getIPAddress());
		assertEquals(time, testConnectionEntities.get(0).getTime());
		assertEquals(sessionId, testConnectionEntities.get(0).getSessionId());
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		boolean append = false;
		for (ConnectionEntity connectionEntity : connectionEntities) {
			FileManagerService.writeTextToFile(connectionEntity.toString(), append);
			append = true;
		}
	}

}
