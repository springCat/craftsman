package com.alibaba.craftsman.common;

import com.alibaba.craftsman.common.dbscript.DbScriptRule;
import org.junit.Rule;

/**
 * @Description RuleTest
 * @Author springCat
 * @Date 2020/6/17 13:54
 */
public class RuleTest {
    @Rule
    public DbScriptRule dbScriptRule = new DbScriptRule();
}
