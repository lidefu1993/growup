package com.ldf.quartz.core.util;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ldf on 2018/6/19.
 */
public class PropertiesUtil {

    /**
     * 根据配置文件 - 创建Quartz配置信息
     * @return
     * @throws IOException
     */
    public static Properties quartzPropertiesBuild() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        Properties properties = propertiesFactoryBean.getObject();
        return properties;
    }

}
