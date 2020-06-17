package com.alibaba.craftsman.common.exception;


import com.alibaba.cola.dto.ErrorCodeI;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ErrorCode
 *
 * @author Frank Zhang
 * @date 2019-01-04 11:00 AM
 */
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeI {

    B_CUSTOMER_companyNameConflict("B_CUSTOMER_companyNameConflict", "客户公司名冲突");

    private final String errCode;
    private final String errDesc;



    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrDesc() {
        return errDesc;
    }
}