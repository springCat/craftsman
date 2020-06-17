package com.alibaba.craftsman.domain.metrics.techcontribution;

import com.alibaba.craftsman.domain.metrics.MetricItem;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计指标度量项
 * @author xueliang.sxl, alisa.hsh, xiangning.lxn
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MiscMetricItem extends MetricItem {

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 文档链接
     */
    private String docUrl;

    /**
     * 代码链接
     */
    private String codeUrl;

    private static double OUTSTANDING_CONTRIBUTION_SCORE = 20;

    public static MiscMetricItem valueOf(String json){
        return JSON.parseObject(json, MiscMetricItem.class);
    }

    /**
     * 计算当前度量项分数
     * @return
     */
    @Override
    public double calculateScore() {
        return OUTSTANDING_CONTRIBUTION_SCORE;
    }
}
