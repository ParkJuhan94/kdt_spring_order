package org.prgrms.kdt.service;

import java.util.List;
import java.util.UUID;
import org.prgrms.kdt.domain.Order;
import org.prgrms.kdt.domain.OrderItem;
import org.prgrms.kdt.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final VoucherService voucherService;
    private final OrderRepository orderRepository;

    public OrderService(VoucherService voucherService, OrderRepository orderRepository) {
        this.voucherService = voucherService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems) {
        var order = new Order(UUID.randomUUID(), customerId, orderItems);
        return orderRepository.insert(order);
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
        var voucher = voucherService.getVoucher(voucherId);
        var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.userVoucher(voucher);
        return order;
    }


}
