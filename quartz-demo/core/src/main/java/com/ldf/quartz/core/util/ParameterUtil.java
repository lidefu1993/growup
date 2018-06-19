package com.ldf.quartz.core.util;

import com.ldf.quartz.core.param.CronTriggerParam;
import com.ldf.quartz.core.param.JobDetailParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;

import static com.ldf.quartz.core.param.CronTriggerParamBuilder.newCronTriggerParam;
import static com.ldf.quartz.core.param.JobDetailParamBuilder.newJobDetailParam;
import static com.ldf.quartz.core.param.SimpleTriggerParamBuilder.newSimpleTriggerParam;

/**
 * Created by ldf on 2018/6/19.
 */
public class ParameterUtil {

    public static JobDetailParam jobDetailParamBuild(JobDetailParam jobDetailParam){
        return newJobDetailParam()
                .setJobName(jobDetailParam.getJobName())
                .setJobGroup(jobDetailParam.getJobGroup())
                .setJobClass(jobDetailParam.getJobClass())
                .build();
    }

    public static SimpleTriggerParam simpleTriggerParamBuild(SimpleTriggerParam triggerParam){
        return newSimpleTriggerParam()
                .setTriggerName(triggerParam.getTriggerName())
                .setTriggerGroup(triggerParam.getTriggerGroup())
                .setRepeatInterval(triggerParam.getRepeatInterval())
                .setRepeatCount(triggerParam.getRepeatCount())
                .setStartAt(triggerParam.getStartAt())
                .setEndAt(triggerParam.getEndAt())
                .setMisfireInstruction(triggerParam.getMisfireInstruction())
                .setPriority(triggerParam.getPriority())
                .setTriggerDescription(triggerParam.getTriggerDescription())
                .build();
    }

    public static CronTriggerParam cronTriggerParamBuild(CronTriggerParam triggerParam){
        return newCronTriggerParam()
                .setTriggerName(triggerParam.getTriggerName())
                .setTriggerGroup(triggerParam.getTriggerGroup())
                .setStartAt(triggerParam.getStartAt())
                .setEndAt(triggerParam.getEndAt())
                .setMisfireInstruction(triggerParam.getMisfireInstruction())
                .setPriority(triggerParam.getPriority())
                .setCronExpression(triggerParam.getCronExpression())
                .setTriggerDescription(triggerParam.getTriggerDescription())
                .build();
    }

}
