package lk.ijse.posbackendphase02.Service;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;

import java.util.List;

public interface OrderService {
    String generateNewOrderId();

    void saveOrder(OrderDto orderDto);

    OrderStatus getOrderById(String orderId);

    List<OrderDto> getAllOrders();
}
