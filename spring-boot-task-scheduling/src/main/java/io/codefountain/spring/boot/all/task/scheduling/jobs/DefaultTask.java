package io.codefountain.spring.boot.all.task.scheduling.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DefaultTask {

	private static final Logger logger = LoggerFactory.getLogger(DefaultTask.class);
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	//@Scheduled(fixedDelay = 5000)
	public void getCurrentTime() {
		logger.info("Time is now {}", simpleDateFormat.format(new Date()));
		try {
			TimeUnit.MILLISECONDS.sleep(8000);
		}
		catch(InterruptedException e) {}
	}
	
}
