package com.ldf.quartz.node1.service;

import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import com.ldf.quartz.core.util.*;
import com.ldf.quartz.node1.job.MyJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by ldf on 2018/6/15.
 */
@Service
public class QuartzService {

    @Autowired
    @Qualifier(value = "node1Schedule")
    private Scheduler scheduler;
    /**
     * @param jobDetailParam
     * @param triggerParam
     * @throws SchedulerException
     */
    public void simpleJobExecute(JobDetailParam jobDetailParam, SimpleTriggerParam triggerParam) throws SchedulerException, ClassNotFoundException, ParseException {
        JobDetail jobDetail = JobDetailUtil.jobDetailBuild(jobDetailParam);
        Trigger trigger = TriggerUtil.simpleTriggerBuild(jobDetail, ParameterUtil.simpleTriggerParamBuild(triggerParam));
        QuartzUtil.scheduleJob(scheduler, jobDetail, trigger);
        scheduler.start();
    }

    /**
     * 关闭调度器
     * @throws SchedulerException
     */
    public void shutdown() throws SchedulerException {
        QuartzUtil.scheduleShutdown(scheduler);
    }

    public boolean delSchedule(String jobName, String jobGroup) throws SchedulerException {
        return QuartzUtil.stopJob(jobName, jobGroup, scheduler);
    }
}
