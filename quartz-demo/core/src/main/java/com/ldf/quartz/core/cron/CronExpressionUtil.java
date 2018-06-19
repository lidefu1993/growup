package com.ldf.quartz.core.cron;

import com.ldf.quartz.core.util.BaseUtil;

/**
 * Created by ldf on 2018/5/11.
 * cron表达式 工具类
 */
public class CronExpressionUtil {

    public static void main(String[] args){
        String s = weekCron("4_11:30:00");
        System.out.println(s);
    }

    /**
     * 获取cron表达式
     * @param performCycle 执行周期
     * @param performTime 执行时间
     * @return
     */
    public static String cronExpressionBuilder(String performCycle, String performTime){
        if(PerformCycle.DAY.name().equals(performCycle)){
            return dayCron(performTime);
        }else if(PerformCycle.WEEK.name().equals(performCycle)){
            return weekCron(performTime);
        }else if(PerformCycle.MONTH.name().equals(performCycle)){
            return monthCron(performTime);
        }else throw new RuntimeException("暂不支持的运行周期");
    }

    /**
     * 日 cron表达式
     * @param performTime
     * @return
     */
    private static String dayCron( String performTime){
        String[] cronArray = {"*","*","*","*","*","?"};
        DayTime detailTime = getDetailTime(performTime);
        cronArray[0] = detailTime.getSecond();
        cronArray[1] = detailTime.getMinute();
        cronArray[2] = detailTime.getHour();
        return cronArrayToString(cronArray);
    }

    /**
     * 周 cron表达式
     * @param performTime
     * @return
     */
    private static String weekCron( String performTime){
        String[] cronArray = {"*","*","*","?","*","*"};
        if(BaseUtil.isEmpty(performTime)) throw new RuntimeException("执行时间为空");
        String[] weekArray = performTime.split("_");
        if(weekArray.length != 2) throw new RuntimeException("执行时间格式不合法");
        cronArray[5] = weekArray[0];
        DayTime detailTime = getDetailTime(weekArray[1]);
        cronArray[0] = detailTime.getSecond();
        cronArray[1] = detailTime.getMinute();
        cronArray[2] = detailTime.getHour();
        return cronArrayToString(cronArray);
    }

    /**
     * 月 cron表达式
     * @param performTime
     * @return
     */
    private static String monthCron( String performTime){
        String[] cronArray = {"*","*","*","*","*","?"};
        if(BaseUtil.isEmpty(performTime)) throw new RuntimeException("执行时间为空");
        String[] weekArray = performTime.split("_");
        if(weekArray.length != 2) throw new RuntimeException("执行时间格式不合法");
        cronArray[3] = weekArray[0];
        DayTime detailTime = getDetailTime(weekArray[1]);
        cronArray[0] = detailTime.getSecond();
        cronArray[1] = detailTime.getMinute();
        cronArray[2] = detailTime.getHour();
        return cronArrayToString(cronArray);
    }

    /**
     * 获取执行时间- 时分秒
     * @param performTime
     * @return
     */
    private static DayTime getDetailTime(String performTime){
        if(BaseUtil.isEmpty(performTime)) throw new RuntimeException("执行时间为空");
        String[] timeArray = performTime.split(":");
        if(timeArray.length != 3) throw new RuntimeException("执行时间格式不合法");
        return DayTime.builder()
                .hour(timeArray[0])
                .minute(timeArray[1])
                .second(timeArray[2])
                .build();
    }

    private static String cronArrayToString(String[] cronArray){
        String cron = "";
        for(int i = 0; i < cronArray.length; i++){
            cron += cronArray[i] + " ";
        }
        return cron.trim();
    }

}
