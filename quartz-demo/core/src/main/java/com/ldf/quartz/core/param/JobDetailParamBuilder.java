package com.ldf.quartz.core.param;

/**
 * Created by ldf on 2018/6/19.
 */
public class JobDetailParamBuilder {

    private String jobName;
    private String jobGroup;
    private String jobClass;
    private String jobDescription;

    private JobDetailParamBuilder(){
    }

    public JobDetailParam build(){
        JobDetailParam jobDetailParam = new JobDetailParam();
        jobDetailParam.setJobName(this.jobName);
        jobDetailParam.setJobGroup(this.jobGroup);
        jobDetailParam.setJobClass(this.jobClass);
        jobDetailParam.setJobDescription(jobDescription);
        return jobDetailParam;
    }

    public static JobDetailParamBuilder newJobDetailParam(){
        return new JobDetailParamBuilder();
    }

    public JobDetailParamBuilder setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public JobDetailParamBuilder setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
        return this;
    }

    public JobDetailParamBuilder setJobClass(String jobClass) {
        this.jobClass = jobClass;
        return this;
    }

    public JobDetailParamBuilder setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }
}
