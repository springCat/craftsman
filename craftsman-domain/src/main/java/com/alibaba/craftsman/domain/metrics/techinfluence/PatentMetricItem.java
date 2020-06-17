package com.alibaba.craftsman.domain.metrics.techinfluence;

import com.alibaba.craftsman.domain.metrics.MetricItem;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 技术创新指标项
 * @author xueliang.sxl
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatentMetricItem extends MetricItem {

    private String patentName;
    private String patentDesc;
    private String patentNo;
    private String patentUrl;
    private AuthorType authorType;

    public static PatentMetricItem valueOf(String json){
        return JSON.parseObject(json, PatentMetricItem.class);
    }

    @Override
    public double calculateScore() {
       return authorType.getScore();
    }

}
