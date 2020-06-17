package com.alibaba.craftsman.domain.metrics;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum MainMetricType {
    APP_QUALITY("app-quality","应用质量"),
    TECH_INFLUENCE("tech-influence","技术影响力"),
    TECH_CONTRIBUTION("tech-contribution","技术贡献"),
    DEV_QUALITY("dev-quality","开发质量");

    private String metricCode;
    private String metricName;

}
