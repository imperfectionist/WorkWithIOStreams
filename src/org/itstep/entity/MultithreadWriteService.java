package org.itstep.entity;

import org.itstep.service.FileManagerService;
import org.itstep.util.Randomizer;

public class MultithreadWriteService implements Runnable {

	@Override
	public void run() {
	
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
