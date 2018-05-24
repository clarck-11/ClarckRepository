package org.clarck.demo;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {

	public static void main(String[] args) throws SchedulerException, ParseException {

		JobDetail job = new JobDetail();
		job.setName("dummyJobName");
		job.setJobClass(HelloJob.class);

		// configure the scheduler time
		CronTrigger trigger = new CronTrigger();
		trigger.setName("dummyTriggerName");
		trigger.setCronExpression("0/3 * * * * ?");

		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

}
