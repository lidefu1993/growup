package com.ldf.quartz.core.param;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ldf on 2018/6/15.
 */
@Data
public class SimpleTriggerParam extends TriggerParam {

    private long repeatInterval;
    private int repeatCount;

}
