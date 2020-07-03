package com.alibaba.craftsman.point;

import com.alibaba.cola.extension.Extension;
import com.alibaba.craftsman.common.BizCode;

@Extension(bizId = BizCode.BIZ_ONE)
public class EnglishPrinterExt implements CountryPrinterExtPt {

    @Override
    public String print() {
        System.out.println("english");
        return "english";
    }
}