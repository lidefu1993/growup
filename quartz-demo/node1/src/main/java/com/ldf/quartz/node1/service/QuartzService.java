package com.ldf.quartz.node1.service;

import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import com.ldf.quartz.core.util.JobDetailUtil;
import com.ldf.quartz.core.util.QuartzUtil;
import com.ldf.quartz.core.util.ScheduleUtil;
import com.ldf.quartz.core.util.TriggerUtil;
import org.quartz.*;
import org.springframework.stereotype.Service;

/**
 * Created by ldf on 2018/6/15.
 */
@Service
public class QuartzService {

    /**
     *
     * @param jobDetailParam
     * @param triggerParam
     * @throws SchedulerException
     */
    public void simpleJobExecute(JobDetailParam jobDetailParam, SimpleTriggerParam triggerParam) throws SchedulerException {
        Scheduler scheduler = ScheduleUtil.defaultScheduleBuild();
        JobDetail jobDetail = JobDetailUtil.jobDetailBuild(jobDetailParam);
        Trigger trigger = TriggerUtil.simpleTriggerBuild(jobDetail, triggerParam);
        QuartzUtil.scheduleJob(scheduler, jobDetail, trigger);
        scheduler.start();
    }

}
