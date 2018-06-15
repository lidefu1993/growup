package com.ldf.quartz.core.param;

import lombok.Builder;
import lombok.Data;

/**
 * Created by ldf on 2018/6/15.
 */
@Data
@Builder
public class JobDetailParam{

    private String jobName;
    private String jobGroup;
    private Class jobClass;
    private String jobDescription;

}
