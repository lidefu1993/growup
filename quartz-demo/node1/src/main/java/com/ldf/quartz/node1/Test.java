package com.ldf.quartz.node1;

import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import com.ldf.quartz.core.util.JobDetailUtil;
import com.ldf.quartz.core.util.QuartzUtil;
import com.ldf.quartz.core.util.ScheduleUtil;
import com.ldf.quartz.core.util.TriggerUtil;
import com.ldf.quartz.node1.job.MyJob1;
import com.ldf.quartz.node1.service.QuartzService;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import java.text.ParseException;

import static com.ldf.quartz.core.param.JobDetailParamBuilder.newJobDetailParam;
import static com.ldf.quartz.core.param.SimpleTriggerParamBuilder.newSimpleTriggerParam;

/**
 * Created by ldf on 2018/6/19.
 */
public class Test {

    public static void main(String[] args) throws SchedulerException {
        System.out.println(MyJob1.class);
//        simpleJobTest();
    }



    private static void simpleJobTest() throws SchedulerException, ClassNotFoundException, ParseException {
        QuartzService quartzService = new QuartzService();
        quartzService.simpleJobExecute(jobDetailParamTest(), simpleTriggerParamTest());
    }

    public void simpleJobExecute(JobDetailParam jobDetailParam, SimpleTriggerParam triggerParam) throws SchedulerException, ClassNotFoundException, ParseException {
        Scheduler scheduler = ScheduleUtil.defaultScheduleBuild();
        JobDetail jobDetail = JobDetailUtil.jobDetailBuild(jobDetailParam);
        Trigger trigger = TriggerUtil.simpleTriggerBuild(jobDetail, triggerParam);
        QuartzUtil.scheduleJob(scheduler, jobDetail, trigger);
        scheduler.start();
    }

    private static JobDetailParam jobDetailParamTest(){
        return newJobDetailParam()
                .setJobName("test-001")
                .setJobGroup("group-001")
                .setJobClass("com.ldf.quartz.node1.job.MyJob1")
                .setJobDescription("测试")
                .build();
    }
    private static SimpleTriggerParam simpleTriggerParamTest(){
        return newSimpleTriggerParam()
                .setTriggerName("test-002")
                .setTriggerGroup("group-003")
                .setRepeatInterval(1000*10)
                .setRepeatCount(1)
                .build();
    }

}
