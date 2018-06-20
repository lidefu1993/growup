package com.ldf.quartz.core.util;

import com.ldf.quartz.core.param.CronTriggerParam;
import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import static org.quartz.JobBuilder.newJob;

/**
 * Created by ldf on 2018/6/15.
 */
public class JobDetailUtil {


    /**
     * JobDetail 构建
     * @param param
     * @return
     */
    public static JobDetail jobDetailBuild(JobDetailParam param) throws ClassNotFoundException {
        return newJob()
                .withIdentity(param.getJobName(), param.getJobGroup())
                .ofType(QuartzUtil.getJobClass(param.getJobClass()))
                .withDescription(param.getJobDescription())
                .requestRecovery(true) //设置任务可恢复
                .build();
    }

}
