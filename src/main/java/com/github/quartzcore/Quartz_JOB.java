package com.github.quartzcore;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.github.daos.EmpDao;

/**
 * To Schedule a job/task to run at specific date & time.
 * <<job>>  component/class has to implement this interface and @execute(). so that the execute()
 * method code will be executed by scheduler when trigger is raised.
 * @author yashwanth.m
 *
 */
public class Quartz_JOB implements Job {
	
	private EmpDao edao;
	
	public EmpDao getEdao() {	return edao;	}
	public void setEdao(EmpDao edao) {	this.edao = edao;	}
	public static Integer size;
	
	@SuppressWarnings("unused")
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Date time = context.getFireTime();
		Date next_trigger_time =context.getNextFireTime();
		System.out.println("### Current Trigget Time : "+time+"### Next Trigger Time : "+next_trigger_time);
		
		/*JobKey job_key = context.getJobDetail().getKey();
		JobDataMap job_dataMap = context.getJobDetail().getJobDataMap();
		String jobSays = job_dataMap.getString("jobSays");
		int record_size = job_dataMap.getInt("Recird_Size");
		
		TriggerKey trigger_key = context.getTrigger().getKey();
		JobDataMap trigger_dataMap = context.getTrigger().getJobDataMap();
		int curr_record_size = trigger_dataMap.getInt("Curr_Record_Size");
		
		System.out.println("Instance " + job_key + " of DumbJob says: " + jobSays + ", and val is: " + record_size);
		System.out.println("Trigger Data : "+curr_record_size);*/
		
		JobKey job_key = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getMergedJobDataMap(); // Get all the keys from Listener.
		System.out.println("Instance " + job_key + " of DumbJob says: " + jobSays + ", and val is: " + record_Size);
		System.out.println("Trigger Data : "+curr_Record_Size);
		
		System.out.println("#######Empdao : "+edao);
	}
	String jobSays;
	int record_Size;
	int curr_Record_Size;
	
	public int getCurr_Record_Size() {	return curr_Record_Size;	}
	public void setCurr_Record_Size(int curr_Record_Size) {	this.curr_Record_Size = curr_Record_Size;	}
	
	public String getJobSays() {	return jobSays;	}
	public void setJobSays(String jobSays) {	this.jobSays = jobSays;	}

	public int getRecird_Size() {	return record_Size;	}
	public void setRecird_Size(int record_Size) {	this.record_Size = record_Size;	}
}