package com.ldf.quartz.core.cron;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ldf on 2018/5/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayTime {
    private String hour;
    private String minute;
    private String second;
}
