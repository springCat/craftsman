package com.alibaba.craftsman.point;

import com.alibaba.cola.extension.Extension;
import com.alibaba.craftsman.common.BizCode;

@Extension
public class DefaultPrinterExt implements CountryPrinterExtPt {

    @Override
    public String print() {
        System.out.println("Default");
        return "Default";
    }
}