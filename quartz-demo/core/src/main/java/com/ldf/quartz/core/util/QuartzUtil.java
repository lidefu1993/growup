package com.ldf.quartz.core.util;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

/**
 * Created by ldf on 2018/6/15.
 */
public class QuartzUtil {


    /**
     * 启动调度器
     * @param scheduler
     * @throws SchedulerException
     */
    public static void scheduleStart(Scheduler scheduler) throws SchedulerException {
        scheduler.start();
    }

    /**
     * 关闭调度器
     * @param scheduler
     * @throws SchedulerException
     */
    public static void scheduleShutdown(Scheduler scheduler) throws SchedulerException {
        scheduler.shutdown();
    }

    /**
     * 添加任务进调度器
     * @param scheduler
     * @param jobDetail
     * @param trigger
     * @throws SchedulerException
     */
    public static void scheduleJob(Scheduler scheduler, JobDetail jobDetail, Trigger trigger) throws SchedulerException {
        scheduler.scheduleJob(jobDetail, trigger);
    }



}
