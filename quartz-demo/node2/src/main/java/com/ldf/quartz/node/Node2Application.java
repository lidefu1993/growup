package com.ldf.quartz.node;

import com.ldf.quartz.core.util.QuartzUtil;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by ldf on 2018/6/15.
 */
@SpringBootApplication(scanBasePackages = {"com.ldf.quartz", "com.ldf.quartz.node"})
public class Node2Application implements CommandLineRunner{

    private static final Logger logger = Logger.getLogger(Node2Application.class);
    public static void main(String[] args){
        SpringApplication.run(Node2Application.class, args);
    }

    @Autowired
    Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        logger.info("-----------------------node2 started------------------------------");
        QuartzUtil.scheduleStart(scheduler);
    }
}
