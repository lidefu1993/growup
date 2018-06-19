package com.ldf.quartz.node1.conf;

import com.ldf.quartz.core.util.PropertiesUtil;
import com.ldf.quartz.core.util.QuartzUtil;
import com.ldf.quartz.core.util.ScheduleUtil;
import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by ldf on 2018/6/15.
 */
@Configuration
public class QuartzConfig {

    @Bean
    public Scheduler node1Schedule(@Qualifier("jobFactory")JobFactory jobFactory) throws Exception {
        return ScheduleUtil.schedulerBuild(PropertiesUtil.quartzPropertiesBuild() ,jobFactory);
    }

}
