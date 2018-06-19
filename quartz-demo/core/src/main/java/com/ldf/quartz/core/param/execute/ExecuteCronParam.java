package com.ldf.quartz.core.param.execute;

import com.ldf.quartz.core.param.CronTriggerParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ldf on 2018/6/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteCronParam extends ExecuteParam {
    private CronTriggerParam triggerParam;
}
