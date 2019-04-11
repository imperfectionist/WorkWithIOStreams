package org.itstep.service;

import org.itstep.entity.MultithreadWriteService;

public class MultithreadService extends Thread {

	private final String threadName;
	
	public MultithreadService(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
//		System.out.println("thread name is " + threadName);
//		FileManagerService.showAsyncImplementation(threadName);
		
		for (int i = 0; i < 5; i++) {
			MultithreadWriteService service = new MultithreadWriteService();
			service.run();
		}
	}
}
