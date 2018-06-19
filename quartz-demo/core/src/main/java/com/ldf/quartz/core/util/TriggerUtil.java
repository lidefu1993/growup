package com.ldf.quartz.core.util;

import com.ldf.quartz.core.param.CronTriggerParam;
import com.ldf.quartz.core.param.SimpleTriggerParam;
import com.ldf.quartz.core.param.TriggerParam;
import org.quartz.*;

import java.text.ParseException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * 触发器构建
 * Created by ldf on 2018/6/15.
 */
public class TriggerUtil {


    /**
     * simpleTrigger构建
     * @param jobDetail
     * @param param
     * @return
     */
    public static Trigger simpleTriggerBuild(JobDetail jobDetail, SimpleTriggerParam param) throws ParseException {
        return commonTriggerBuilderBuild(jobDetail, param)
                .withSchedule( scheduleBuilderBuild(param) )
                .startAt(BaseUtil.strToDate(param.getStartAt()))
                .endAt(BaseUtil.strToDate(param.getEndAt()))
                .build();
    }

    /**
     * cronTrigger构建
     * @param jobDetail
     * @param param
     * @return
     */
    public static Trigger cronTriggerBuild(JobDetail jobDetail, CronTriggerParam param) throws ParseException {
        return commonTriggerBuilderBuild(jobDetail, param)
                .withSchedule( cronScheduleBuilderBuild(param) )
                .build();
    }


    /**
     * 公共部分的TriggerBuilder构建
     * @param jobDetail
     * @param param
     * @return
     */
    private static TriggerBuilder commonTriggerBuilderBuild(JobDetail jobDetail, TriggerParam param) throws ParseException {
        return newTrigger()
                .withIdentity(param.getTriggerName(), param.getTriggerGroup())
                .startAt(BaseUtil.strToDate(param.getStartAt()))
                .endAt(BaseUtil.strToDate(param.getEndAt()))
                .forJob(jobDetail)
                .withPriority(param.getPriority());
    }

    /**
     * SimpleScheduleBuilder
     * @param param
     * @return
     */
    private static SimpleScheduleBuilder scheduleBuilderBuild(SimpleTriggerParam param){
        return simpleScheduleBuilderMisfireBuild(
                simpleSchedule()
                .withIntervalInMilliseconds(param.getRepeatInterval())
                .withRepeatCount(param.getRepeatCount())
                .withMisfireHandlingInstructionFireNow(), param.getMisfireInstruction());
    }

    /**
     * simpleTrigger的misfire机制
     * @param builder
     * @param misfireInstruction
     * @return
     */
    private static SimpleScheduleBuilder simpleScheduleBuilderMisfireBuild(SimpleScheduleBuilder builder, int misfireInstruction){
        if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY){
            return builder.withMisfireHandlingInstructionIgnoreMisfires();
        }else if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW){
            return builder.withMisfireHandlingInstructionFireNow();
        }else if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT){
            return builder.withMisfireHandlingInstructionNowWithExistingCount();
        }else if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT){
            return builder.withMisfireHandlingInstructionNowWithRemainingCount();
        }else if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT){
            return builder.withMisfireHandlingInstructionNextWithRemainingCount();
        }else if(misfireInstruction == SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT){
            return  builder.withMisfireHandlingInstructionNextWithExistingCount();
        }else {
            return builder.withMisfireHandlingInstructionIgnoreMisfires();
        }

    }

    /**
     * CronScheduleBuilder构建
     * @param param
     * @return
     */
    private static CronScheduleBuilder cronScheduleBuilderBuild(CronTriggerParam param){
        return ( cronScheduleBuilderMisfireBuild(
                cronSchedule(param.getCronExpression()),param
                ) );
    }

    /**
     * CronScheduleBuilder 的 misfire机制
     * @param builder
     * @param param
     * @return
     */
    private static CronScheduleBuilder cronScheduleBuilderMisfireBuild(CronScheduleBuilder builder, CronTriggerParam param){
        if(param.getMisfireInstruction() == CronTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY){
            return builder.withMisfireHandlingInstructionIgnoreMisfires();
        }else if(param.getMisfireInstruction() == CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW){
            return builder.withMisfireHandlingInstructionFireAndProceed();
        }else if(param.getMisfireInstruction() == CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING){
            return builder.withMisfireHandlingInstructionDoNothing();
        }else {
            return builder.withMisfireHandlingInstructionDoNothing();
        }

    }





}
