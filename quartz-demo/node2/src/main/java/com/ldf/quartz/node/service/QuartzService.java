package com.ldf.quartz.node.service;

import com.ldf.quartz.core.param.CronTriggerParam;
import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import com.ldf.quartz.core.util.JobDetailUtil;
import com.ldf.quartz.core.util.ParameterUtil;
import com.ldf.quartz.core.util.QuartzUtil;
import com.ldf.quartz.core.util.TriggerUtil;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
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
    }

    public void cronJobExecute(JobDetailParam jobDetailParam, CronTriggerParam triggerParam) throws ClassNotFoundException, ParseException, SchedulerException {
        JobDetail jobDetail = JobDetailUtil.jobDetailBuild(jobDetailParam);
        Trigger trigger = TriggerUtil.cronTriggerBuild(jobDetail, ParameterUtil.cronTriggerParamBuild(triggerParam));
        QuartzUtil.scheduleJob(scheduler, jobDetail, trigger);
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

    public void startSchedule() throws SchedulerException {
        QuartzUtil.scheduleStart(scheduler);
    }
}
