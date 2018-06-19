package com.ldf.quartz.core.param;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ldf on 2018/6/15.
 */
@Data
@NoArgsConstructor
public class JobDetailParam{

    private String jobName;
    private String jobGroup;
    private String jobClass;
    private String jobDescription;

}
