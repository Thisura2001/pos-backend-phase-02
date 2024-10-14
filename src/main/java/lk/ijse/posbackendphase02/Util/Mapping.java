package lk.ijse.posbackendphase02.Util;

import jakarta.persistence.criteria.Order;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderDetailEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for user mapping
    public CustomerEntity ToCustomerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto ToCustomerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public List<CustomerDto> asCustomerDtoList(List<CustomerEntity> customerEntities){
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDto>>() {}.getType());
    }

    public ItemEntity ToItemEntity(ItemDto itemDto){
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto ToItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDto.class);
    }
    public List<ItemDto> asItemDtoList(List<ItemEntity> itemEntities){
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDto>>() {}.getType());
    }
    public OrderEntity ToOrderEntity(OrderDto orderDto){
        return new OrderEntity(orderDto.getOrderId(), orderDto.getAmount(), orderDto.getNetTotal(), orderDto.getDiscount(),
                orderDto.getFinalTotal(),null, null);
    }
    public OrderDto ToOrderDto(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderDto.class);
    }
    public List<OrderDto> asOrderDtoList(List<OrderEntity> orderEntities){
        return modelMapper.map(orderEntities, new TypeToken<List<OrderDto>>() {}.getType());
    }

    public OrderDetailEntity ToOrderDetailEntity(OrderDetailDto orderDetailDto){
        return modelMapper.map(orderDetailDto, OrderDetailEntity.class);
    }
    public OrderDetailDto ToOrderDetailDto(OrderDetailEntity orderDetailEntity){
        return modelMapper.map(orderDetailEntity, OrderDetailDto.class);
    }
    public List<OrderDetailDto> asOrderDetailDtoList(List<OrderDetailEntity> orderDetailEntities){
        return modelMapper.map(orderDetailEntities, new TypeToken<List<OrderDetailDto>>() {}.getType());
    }
}
