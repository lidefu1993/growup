package com.ldf.quartz.core.param;

import com.ldf.quartz.core.util.BaseUtil;
import org.quartz.Trigger;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by ldf on 2018/6/15.
 */
public class SimpleTriggerParamBuilder {

    private String triggerName;
    private String triggerGroup;
    private Date startAt;
    private Date endAt;
    private int misfireInstruction = Trigger.MISFIRE_INSTRUCTION_SMART_POLICY;
    private String triggerDescription;
    private int priority;
    private long repeatInterval;
    private int repeatCount;

    private SimpleTriggerParamBuilder() {
    }

    public static SimpleTriggerParamBuilder newSimpleTriggerParam(){
        return new SimpleTriggerParamBuilder();
    }

    public SimpleTriggerParam build(){
        SimpleTriggerParam param = new SimpleTriggerParam();
        param.setTriggerName(triggerName);
        param.setTriggerGroup(triggerGroup);
        param.setStartAt(startAt);
        param.setEndAt(endAt);
        param.setRepeatInterval(repeatInterval);
        param.setRepeatCount(repeatCount);
        param.setMisfireInstruction(misfireInstruction);
        param.setPriority(priority);
        return param;
    }

    public SimpleTriggerParamBuilder setTriggerName(String triggerName) {
        this.triggerName = triggerName;
        return this;
    }

    public SimpleTriggerParamBuilder setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
        return this;
    }

    public SimpleTriggerParamBuilder setStartAt(Date startAt) {
        if(startAt == null) startAt = new Date();
        this.startAt = startAt;
        return this;
    }

    public SimpleTriggerParamBuilder setEndAt(Date endAt) throws ParseException {
        if(endAt == null) endAt = BaseUtil.strToDate("2100-06-15 00:00:00");
        this.endAt = endAt;
        return this;
    }

    public SimpleTriggerParamBuilder setMisfireInstruction(int misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
        return this;
    }

    public SimpleTriggerParamBuilder setTriggerDescription(String triggerDescription) {
        this.triggerDescription = triggerDescription;
        return this;
    }

    public SimpleTriggerParamBuilder setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public void setRepeatInterval(long repeatInterval) {
        if(repeatInterval == 0) repeatInterval = 1000;
        this.repeatInterval = repeatInterval;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }
}
