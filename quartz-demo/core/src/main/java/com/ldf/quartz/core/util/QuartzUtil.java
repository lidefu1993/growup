package com.ldf.quartz.core.util;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    /**
     * 关闭任务
     * @param jobName
     * @param jobGroup
     * @param scheduler
     * @return
     * @throws SchedulerException
     */
    public static boolean stopJob(String jobName, String jobGroup, Scheduler scheduler) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        return scheduler.deleteJob(jobKey);
    }

    public static List<JobKey> getAllJobs(Scheduler scheduler) throws SchedulerException {
        List<JobKey> allJobs = new ArrayList<>();
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        jobGroupNames.stream().forEach(jobGroupName->{
            try {
                allJobs.addAll(scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName)));
            } catch (SchedulerException e) {
                e.printStackTrace();
            }

        });
        return allJobs;
    }

    public static Class getJobClass(String jobClass) throws ClassNotFoundException {
        return (Class<? extends Job>) Class.forName(jobClass);
    }


}
