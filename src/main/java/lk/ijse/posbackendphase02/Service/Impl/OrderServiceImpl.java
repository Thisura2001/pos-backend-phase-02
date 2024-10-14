package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderDetailEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Repository.ItemRepo;
import lk.ijse.posbackendphase02.Repository.OrderDetailRepo;
import lk.ijse.posbackendphase02.Repository.OrderRepo;
import lk.ijse.posbackendphase02.Service.OrderDetailService;
import lk.ijse.posbackendphase02.Service.OrderService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private Mapping orderMapper;
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    public String generateNewOrderId() {
        Optional<OrderEntity> lastOrder = orderRepo.findTopByOrderByOrderIdDesc();
        String lastOrderId = lastOrder.map(OrderEntity::getOrderId).orElse("OR-000");

        int newIdNumber = Integer.parseInt(lastOrderId.replace("OR-", "")) + 1;
        return "OR-" + String.format("%03d", newIdNumber);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        // Map to OrderEntity
        OrderEntity orderEntity = orderMapper.ToOrderEntity(orderDto);

        // Save the order first
        orderRepo.save(orderEntity);

        // If there are order details, map and save them
        if (orderDto.getOrderDetails() != null && !orderDto.getOrderDetails().isEmpty()) {
            List<OrderDetailEntity> orderDetails = orderDto.getOrderDetails().stream()
                    .map(orderDetailDto -> {
                        OrderDetailEntity orderDetailEntity = orderMapper.ToOrderDetailEntity(orderDetailDto);
                        orderDetailEntity.setOrder(orderEntity); // Set the parent order
                        return orderDetailEntity;
                    }).collect(Collectors.toList());

            // Save order details
            orderDetailRepo.saveAll(orderDetails);
        }
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
