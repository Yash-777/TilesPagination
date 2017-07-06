package com.github.quartzcore;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

public class Quartz_2_1_5 {
	public static void main(String[] args) throws SchedulerException {
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
		
		HolidayCalendar workdayCalendar = new HolidayCalendar();

		//Create a holiday for New Year's Day (observed) and add it to the
		//  calendar.
		java.util.Calendar holidayCalendar =  java.util.Calendar.getInstance();
		holidayCalendar.set(2006, java.util.Calendar.JANUARY, 2);
		workdayCalendar.addExcludedDate(holidayCalendar.getTime());

		//continue adding working holidays ...

		scheduler.addCalendar("workingDayCalendar", workdayCalendar, false, false);
		
		/* Quartz1.6.3
		JobDetail job = new JobDetail();
		job.setName("dummyJobName");
		job.setJobClass(Quartz_JOB.class);
		*/
		JobDetail job1 = JobBuilder
						.newJob(Quartz_JOB.class)
						/*.withIdentity("New Job ID1", "Group1")*/
						.build();
		JobDetail job2 = JobBuilder
				.newJob(Quartz_JOB2.class)
				/*.withIdentity("New Job ID2", "Group1")*/
				.build();
		
		/*CronTrigger – Allows Unix cron expression to specify the dates and times to run your job.*/
		/*SimpleTrigger trigger = new SimpleTrigger();
		trigger.setName("dummyTriggerName");
		trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		trigger.setRepeatInterval(30000);*/
		
		/*CronTrigger trigger = new CronTrigger();
		trigger.setName("dummyTriggerName");
		trigger.setCronExpression("0/30 * * * * ?");*/
		
		Trigger trigger1 = TriggerBuilder
				.newTrigger()
				/*.withIdentity("New Trigger ID", "Group1")*/
				/*.forJob("New Job ID1", "Group1")*/
				/*.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(5).repeatForever())*/
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();
		Trigger trigger2 = TriggerBuilder
				.newTrigger()
				/*.withIdentity("New Trigger ID2", "Group1")
				.forJob("New Job ID2", "Group1")*/
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(5).repeatForever())
				/*.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))*/
				.build();
		
		System.out.println("Scheduler Started ");
		
		scheduler.start();
		scheduler.scheduleJob(job1, trigger1);
		
		scheduler2.start();
		scheduler2.scheduleJob(job2, trigger2);
		
		System.out.println("Scheduler paused based on group ");
		scheduler.pauseJob(job1.getKey()); 
		
		System.out.println("Scheduler Resume");
		scheduler.resumeAll();
		
		/*System.out.println("Scheduler Shutdown");
		scheduler.shutdown();
		
		System.out.println("once scheduler Shutdown cannot be started as instance is removed");
		scheduler.start();*/
		// The Scheduler cannot be restarted after shutdown() has been called.
		/*java.lang.IncompatibleClassChangeError: Implementing class
		then having quartz 2 version jar files in class path */
	}
}