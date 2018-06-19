package com.ldf.quartz.node1;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by ldf on 2018/6/15.
 */
@SpringBootApplication(scanBasePackages = {"com.ldf.quartz","com.ldf.quartz.node1"} )
public class Node1Application implements CommandLineRunner{
    private static final Logger logger = Logger.getLogger(Node1Application.class);
    public static void main(String[] args){
        SpringApplication.run(Node1Application.class, args);
    }

    @Autowired
    @Qualifier(value = "node1Schedule")
    public Scheduler scheduler;
    @Override
    public void run(String... args) throws Exception {
        scheduler.start();
        logger.info("---------------------------node1 started-----------------------------------");
    }
}
