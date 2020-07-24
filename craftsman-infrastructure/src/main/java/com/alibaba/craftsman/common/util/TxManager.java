package com.alibaba.craftsman.common.util;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.util.function.Supplier;

/**
 * @Description TransactioUtil
 * @Author springCat
 * @Date 2020/6/16 11:31
 */

@Service
public class TxManager {

    @Resource(name = "craftsmanDataSourceTransactionManager")
    private DataSourceTransactionManager craftsmanDataSourceTransactionManager;

    @Resource(name = "craftsman1DataSourceTransactionManager")
    private DataSourceTransactionManager craftsman1DataSourceTransactionManager;


    public <T> Supplier<T> executeCraftsman(Supplier<T> supplier){
        return execute(craftsmanDataSourceTransactionManager,TransactionDefinition.PROPAGATION_REQUIRES_NEW,supplier);
    }

    public <T> Supplier<T> executeCraftsman1(Supplier<T> supplier){
        return execute(craftsman1DataSourceTransactionManager,TransactionDefinition.PROPAGATION_REQUIRES_NEW,supplier);
    }

    public <T> Supplier<T> execute( DataSourceTransactionManager transactionManager,int propagationBehavior,Supplier<T> supplier) {
        Supplier<T> txSupplier = () -> {
            //2.获取事务定义
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            //3.设置事务隔离级别，开启新事务
            def.setPropagationBehavior(propagationBehavior);
            //4.获得事务状态
            TransactionStatus transactionStatus = transactionManager.getTransaction(def);
            try {
                T result = supplier.get();
                transactionManager.commit(transactionStatus);
                return result;
            } catch (Exception e) {
                transactionManager.rollback(transactionStatus);
                throw e;
            }
        };
        return txSupplier;
    }
}
