package com.ldf.quartz.core.util;

import com.ldf.quartz.core.param.JobDetailParam;
import org.quartz.JobDetail;

import static org.quartz.JobBuilder.newJob;

/**
 * Created by ldf on 2018/6/15.
 */
public class JobDetailUtil {


    /**
     * JobDetail 构建
     * @param param
     * @return
     */
    public static JobDetail jobDetailBuild(JobDetailParam param){
        return newJob()
                .withIdentity(param.getJobName(), param.getJobGroup())
                .withDescription(param.getJobDescription())
                .build();
    }


    /**
     * jobdetail参数构建
     * @param jobName
     * @param jobGroup
     * @param jobDescription
     * @param jobClass
     * @return
     */
    public static JobDetailParam jobDetailParamBuild(String jobName, String jobGroup,
                                                     String jobDescription, Class jobClass){
        return JobDetailParam.builder()
                .jobName(jobName)
                .jobGroup(jobGroup)
                .jobDescription(jobDescription)
                .jobClass(jobClass)
                .build();

    }

}
