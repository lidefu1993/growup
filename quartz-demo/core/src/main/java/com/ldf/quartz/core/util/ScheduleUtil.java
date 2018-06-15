package com.ldf.quartz.core.util;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ldf on 2018/6/15.
 */
public class ScheduleUtil {

    public static Scheduler defaultScheduleBuild() throws SchedulerException {
        return StdSchedulerFactory.getDefaultScheduler();
    }

    public static Scheduler schedulerBuild(Properties properties) throws SchedulerException {
        StdSchedulerFactory sf = new StdSchedulerFactory();
        sf.initialize(properties);
        return sf.getScheduler();
    }

    public static Scheduler schedulerBuild(Properties properties, JobFactory jobFactory) throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(properties);
        factory.afterPropertiesSet();
        Scheduler scheduler = factory.getScheduler();
        scheduler.setJobFactory(jobFactory);
        return scheduler;
    }

    private Scheduler schedulerBuild(JobFactory jobFactory, DataSource dataSource, Properties properties) throws Exception {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setDataSource(dataSource);
        factory.setQuartzProperties(properties);
        factory.afterPropertiesSet();
        Scheduler scheduler = factory.getScheduler();
        scheduler.setJobFactory(jobFactory);
        return scheduler;
    }


}
