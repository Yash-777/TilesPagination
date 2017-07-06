package com.github.serviceSchedulers;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
 
public class DemoServiceBasicUsageFixedDelay {
	/*
	fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running.
	fixedDelay specifically controls the next execution time when the last execution finishes.
	*/
	
	@Scheduled(fixedDelay = 50000)
	public void demo_fixedDelayd() {
		System.out.println("fixedDelayd - Method executed at every 50 seconds. Current time is :: "+ new Date());
	}
	
	/* link : http://howtodoinjava.com/2013/04/23/4-ways-to-schedule-tasks-in-spring-3-scheduled-example/
	cron is a feature originating from Unix cron utility and has various options based on your requirements.
	
	cron expression will be defined in a properties file and key of related property will be used in 
	@Scheduled annotation.thus making changes easy.
	*/
	@Scheduled(cron = "${cron.expression}") // cron="*/5 * * * * ?"
	public void demo_cron() {
		System.out.println("Corn - Method executed at every 5 seconds. Current time is :: "+ new Date());
	}
}