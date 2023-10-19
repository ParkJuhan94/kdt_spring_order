package org.prgrms.kdt;

import org.prgrms.kdt.configuration.AwsConfiguration;
import org.prgrms.kdt.order.Order;
import org.prgrms.kdt.voucher.Voucher;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Order.class, Voucher.class, AwsConfiguration.class})
public class AppConfiguration {

}
