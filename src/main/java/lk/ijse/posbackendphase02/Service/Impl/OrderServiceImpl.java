package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderDetailEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Repository.CustomerRepo;
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
    private CustomerRepo customerRepo;
    @Autowired
    private Mapping orderMapper;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String generateNewOrderId() {
        Optional<OrderEntity> lastOrder = orderRepo.findTopByOrderByOrderIdDesc();
        String lastOrderId = lastOrder.map(OrderEntity::getOrderId).orElse("OR-000");

        int newIdNumber = Integer.parseInt(lastOrderId.replace("OR-", "")) + 1;
        return "OR-" + String.format("%03d", newIdNumber);
    }

    @Override
    public void saveOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderMapper.ToOrderEntity(orderDto);
        CustomerEntity searchedCustomer = customerRepo.getReferenceById(orderDto.getOrderDetails().get(0).getCustomerId());
        orderEntity.setCustomer(searchedCustomer);
        System.out.println("order entity: " + orderEntity);

        // Save the order first
        OrderEntity saveOrder = orderRepo.save(orderEntity);
//
        if (saveOrder != null) {
            // If the order is saved successfully, insert data into the order details
            for (OrderDetailDto orderDetailDto : orderDto.getOrderDetails()) {
                // Map OrderDetailDto to OrderDetailEntity
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

                // Set the relevant fields
                orderDetailEntity.setOrder(saveOrder);
                orderDetailEntity.setItem(itemRepo.getReferenceById(orderDetailDto.getItemCode()));
                orderDetailEntity.setItemName(orderDetailDto.getItemName());
                orderDetailEntity.setQty(orderDetailDto.getQty());
                orderDetailEntity.setUnitPrice(orderDetailDto.getUnitPrice());

                // Save the order detail to the database
                OrderDetailEntity saveOrderDetail = orderDetailRepo.save(orderDetailEntity);
                if (saveOrderDetail != null) {
                    // If the order detail is saved successfully, update the item quantity
                    ItemEntity itemEntity = itemRepo.getReferenceById(orderDetailDto.getItemCode());

                    // Convert String to int
                    int currentQty = Integer.parseInt(itemEntity.getQty());
                    int orderedQty = Integer.parseInt(orderDetailDto.getQty());


                    itemEntity.setQty(String.valueOf(currentQty - orderedQty));
                    itemRepo.save(itemEntity);
                }

            }
        } else {
            throw new IllegalStateException("Failed to save the order.");
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
