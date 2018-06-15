package com.ldf.quartz.node1.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by ldf on 2018/6/15.
 */
public class MyJob1 implements Job {
    private static final Logger logger = Logger.getLogger(MyJob1.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.debug("---------------------MyJob1----------------------");
        logger.debug(" jobKey: " + context.getJobDetail().getKey().toString());
    }

}
