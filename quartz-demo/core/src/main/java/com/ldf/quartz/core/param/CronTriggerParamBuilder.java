package com.ldf.quartz.core.param;

import org.quartz.Trigger;

import java.util.Date;

/**
 * Created by ldf on 2018/6/15.
 */
public class CronTriggerParamBuilder {

    private String triggerName;
    private String triggerGroup;
    private Date startAt;
    private Date endAt;
    private int misfireInstruction = Trigger.MISFIRE_INSTRUCTION_SMART_POLICY;
    private String triggerDescription;
    private int priority;
    private String cronExpression;

    private CronTriggerParamBuilder(){

    }

    private static CronTriggerParamBuilder newCronTriggerParam(){
        return new CronTriggerParamBuilder();
    }

    private CronTriggerParam build(){
        CronTriggerParam param = new CronTriggerParam();
        param.setTriggerName(triggerName);
        param.setTriggerGroup(triggerGroup);
        param.setStartAt(startAt);
        param.setEndAt(endAt);
        param.setMisfireInstruction(misfireInstruction);
        param.setPriority(priority);
        param.setCronExpression(cronExpression);
        return param;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public void setMisfireInstruction(int misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public void setTriggerDescription(String triggerDescription) {
        this.triggerDescription = triggerDescription;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
