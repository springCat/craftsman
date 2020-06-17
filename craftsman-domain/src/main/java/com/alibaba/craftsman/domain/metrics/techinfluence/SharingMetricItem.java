package com.alibaba.craftsman.domain.metrics.techinfluence;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.craftsman.domain.metrics.MetricItem;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * SharingMetricItem
 * 技术线下分享指标项
 * @author Frank Zhang
 * @date 2018-07-04 3:20 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SharingMetricItem extends MetricItem {

    private static Logger logger = LoggerFactory.getLogger(SharingMetricItem.class);

    private String sharingName;
    private SharingScope sharingScope;
    private Date sharingDate;
    private String sharingLink;


    public static SharingMetricItem valueOf(String json){
        return JSON.parseObject(json, SharingMetricItem.class);
    }

    @Override
    public double calculateScore() {
        return sharingScope.getScore();
    }

}
