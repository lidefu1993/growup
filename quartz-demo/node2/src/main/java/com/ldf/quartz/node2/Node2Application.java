package com.ldf.quartz.node2;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ldf on 2018/6/15.
 */
@SpringBootApplication(scanBasePackages = {"com.ldf.quartz","com.ldf.quartz.node2"})
public class Node2Application implements CommandLineRunner{

    private static final Logger logger = Logger.getLogger(Node2Application.class);
    public static void main(String[] args){
        SpringApplication.run(Node2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("-----------------------node2 started------------------------------");
    }
}
