package com.ldf.quartz.core.param;

import com.ldf.quartz.core.util.BaseUtil;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.quartz.Trigger;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by ldf on 2018/6/15.
 */
@Setter
@Accessors(chain = true)
public class CronTriggerParamBuilder {

    private String triggerName;
    private String triggerGroup;
    private String startAt;
    private String endAt;
    private int misfireInstruction = Trigger.MISFIRE_INSTRUCTION_SMART_POLICY;
    private String triggerDescription;
    private int priority = 5;
    private String cronExpression;

    private CronTriggerParamBuilder(){

    }

    public static CronTriggerParamBuilder newCronTriggerParam(){
        return new CronTriggerParamBuilder();
    }

    public CronTriggerParam build(){
        CronTriggerParam param = new CronTriggerParam();
        param.setTriggerName(triggerName);
        param.setTriggerGroup(triggerGroup);
        if(BaseUtil.isEmpty(this.startAt)) this.startAt = BaseUtil.getNowStr();
        param.setStartAt(startAt);
        if(this.endAt != null) param.setEndAt(endAt);
        param.setMisfireInstruction(misfireInstruction);
        param.setPriority(priority);
        param.setCronExpression(cronExpression);
        param.setTriggerDescription(triggerDescription);
        return param;
    }

}
