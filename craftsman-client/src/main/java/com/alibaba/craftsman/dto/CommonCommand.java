package com.alibaba.craftsman.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * 整个应用通用的Command
 *
 * @author Frank Zhang
 * @date 2019-02-28 7:18 PM
 */
@Data
public class CommonCommand extends Command{

    private String operater;
    private boolean needsOperator;

    public void setOperater(String operater) {
        this.operater = operater;
        needsOperator = true;
    }
}
