package org.prgrms.kdt;

import org.prgrms.kdt.configuration.AwsConfiguration;
import org.prgrms.kdt.order.Order;
import org.prgrms.kdt.voucher.Voucher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Order.class, Voucher.class, AwsConfiguration.class})
public class AppConfiguration {

    @Bean(initMethod = "init")
    public BeanOne beanOne() {
        return new BeanOne();
    }
}

class BeanOne implements InitializingBean {

    private void init() {
        System.out.println("[BeanOne] init called!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[BeanOne] afterPropertiesSet called!");
    }
}
