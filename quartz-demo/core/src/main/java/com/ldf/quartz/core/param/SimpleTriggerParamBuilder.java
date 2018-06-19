package com.ldf.quartz.core.param;

import com.ldf.quartz.core.util.BaseUtil;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.quartz.Trigger;

import java.text.ParseException;
import java.util.Date;

/**
 * SimpleTriggerParam构造器
 * Created by ldf on 2018/6/15.
 */
@Setter
@Accessors(chain = true)
public class SimpleTriggerParamBuilder {
    private final String DEFAULT_GROUP = "default_group";
    private final long DEFAULT_INTERVAL = 1000*10;
    private String triggerName;
    private String triggerGroup;
    private String startAt;
    private String endAt;
    private int misfireInstruction = Trigger.MISFIRE_INSTRUCTION_SMART_POLICY;
    private String triggerDescription;
    private int priority = 5;
    private long repeatInterval;
    private int repeatCount;

    private SimpleTriggerParamBuilder() {
    }

    public static SimpleTriggerParamBuilder newSimpleTriggerParam(){
        return new SimpleTriggerParamBuilder();
    }

    public SimpleTriggerParam build(){
        SimpleTriggerParam param = new SimpleTriggerParam();
        if(BaseUtil.isEmpty(this.triggerName)){
            this.triggerName = BaseUtil.createUUID();
        }
        param.setTriggerName(triggerName);
        if(BaseUtil.isEmpty(this.triggerGroup)){
            this.triggerGroup = DEFAULT_GROUP;
        }
        param.setTriggerGroup(triggerGroup);
        if(BaseUtil.isEmpty(this.startAt)) {
           startAt = BaseUtil.getNowStr();
        }
        param.setStartAt(startAt);
        if(BaseUtil.isEmpty(this.endAt)){
            this.endAt = "2100-01-01 12:00:00";
        }
        param.setEndAt(endAt);
        if(repeatInterval == 0) {
            repeatInterval = DEFAULT_INTERVAL;
        }
        param.setRepeatInterval(repeatInterval);
        param.setRepeatCount(repeatCount);
        param.setMisfireInstruction(misfireInstruction);
        param.setPriority(priority);
        param.setTriggerDescription(this.triggerDescription);
        return param;
    }

}
