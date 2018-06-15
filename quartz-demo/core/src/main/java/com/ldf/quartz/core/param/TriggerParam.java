package com.ldf.quartz.core.param;

import lombok.Data;
import org.quartz.Trigger;

import java.util.Date;

/**
 * Created by ldf on 2018/6/15.
 */
@Data
public class TriggerParam {

    private String triggerName;
    private String triggerGroup;
    private Date startAt;
    private Date endAt;
    private int misfireInstruction = Trigger.MISFIRE_INSTRUCTION_SMART_POLICY;
    private String triggerDescription;
    private int priority;

}
