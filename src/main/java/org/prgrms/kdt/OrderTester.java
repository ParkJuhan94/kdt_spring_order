package org.prgrms.kdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;
import org.prgrms.kdt.order.OrderItem;
import org.prgrms.kdt.voucher.FixedAmountVoucher;
import org.prgrms.kdt.voucher.VoucherRepository;
import org.prgrms.kdt.order.OrderService;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class OrderTester {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        var customerId = UUID.randomUUID();

        var voucherRepository = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
            applicationContext.getBeanFactory(), VoucherRepository.class, "memory");

        var voucher = voucherRepository.insert(new FixedAmountVoucher(UUID.randomUUID(), 10L));

        var orderService = applicationContext.getBean(OrderService.class);

        var order = orderService.createOrder(
            customerId, new ArrayList<OrderItem>() {{
                add(new OrderItem(UUID.randomUUID(), 100L, 1));
            }}, voucher.getVoucherId());


        Assert.isTrue(order.totalAmount() == 90L,
            MessageFormat.format("totalAmount {0}L is not 90L ", order.totalAmount()));
    }
}
