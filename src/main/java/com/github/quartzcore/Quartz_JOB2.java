package com.github.quartzcore;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Quartz_JOB2 implements Job {
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("#########################job2");
	}
}
