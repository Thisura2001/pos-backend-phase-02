package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import lk.ijse.posbackendphase02.Repository.OrderRepo;
import lk.ijse.posbackendphase02.Service.OrderService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private Mapping orderMapper;
    @Override
    public String generateNewOrderId() {
        Optional<OrderEntity> lastOrder = orderRepo.findTopByOrderByOrderIdDesc();
        String lastOrderId = lastOrder.map(OrderEntity::getOrderId).orElse("OR-000");

        int newIdNumber = Integer.parseInt(lastOrderId.replace("OR-", "")) + 1;
        return "OR-" + String.format("%03d", newIdNumber);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        orderRepo.save(orderMapper.ToOrderEntity(orderDto));
    }

    @Override
    public OrderStatus getOrderById(String orderId) {
        Optional<OrderEntity> orderEntity = orderRepo.findById(orderId);
        if(orderEntity.isPresent()){
            return orderMapper.ToOrderDto(orderEntity.get());
        }
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepo.findAll();
        return orderMapper.asOrderDtoList(orderEntities);
    }
}
