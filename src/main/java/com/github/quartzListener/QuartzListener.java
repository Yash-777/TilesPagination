package com.github.quartzListener;

import javax.servlet.ServletContextEvent;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import com.github.quartzcore.Quartz_JOB;

/*@WebListener*/
public class QuartzListener extends QuartzInitializerListener {
	Scheduler scheduler = null;
	Integer size = null;
	@Override
	public void contextInitialized(ServletContextEvent servletContext) {
		System.out.println("Context Initialized");
		//org.quartz.SchedulerException: File named 'quartz_data.xml' does not exist.
		try {
			// JobDetails used to create instances of a class which Implement <<job>>
			// <<JobBuilder>> used to define/build instances of <<JobDetails>>. Which define instances of job.
			JobDetail job1 = JobBuilder
					.newJob(Quartz_JOB.class)
					.withIdentity("Job_ID", "Group1")
					.usingJobData("jobSays", "Hello World!")
					.usingJobData("recird_Size", 3)
					.build();
			
			// <<Trigger>> a component that defines the scheduled 'Time Interval'. So that the given job to execute.
			// << TriggerBuilder>> used to create Trigger Instance.
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("Trigger_ID", "Group1")
					.forJob("Job_ID", "Group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
					.usingJobData("curr_Record_Size", 10)//edto.getEmpList().size()*/)
					.build();
	
			// Setup the Job and Trigger with Scheduler & schedule jobs
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job1, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		System.out.println("Context Destroyed");
		try {
			scheduler.shutdown();
			System.out.println("Quartz stoped");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}