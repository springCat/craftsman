package com.alibaba.craftsman.domain.metrics.techinfluence;

import com.alibaba.craftsman.domain.metrics.MetricItem;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * PaperMetricItem
 *
 * @author Frank Zhang
 * @date 2018-09-20 3:26 PM
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaperMetricItem extends MetricItem {

	private String paperName;
	private String paperDesc;
	private String magazine;
	private String paperLink;

	private static final double PAPER_SCORE = 10;


	public static PaperMetricItem valueOf(String json){
		return JSON.parseObject(json, PaperMetricItem.class);
	}

	@Override
	public double calculateScore() {
		return PAPER_SCORE;
	}
}
