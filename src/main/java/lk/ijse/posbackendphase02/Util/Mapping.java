package lk.ijse.posbackendphase02.Util;

import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
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
        return modelMapper.map(orderDto, OrderEntity.class);
    }
    public OrderDto ToOrderDto(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderDto.class);
    }
    public List<OrderDto> asOrderDtoList(List<OrderEntity> orderEntities){
        return modelMapper.map(orderEntities, new TypeToken<List<OrderDto>>() {}.getType());
    }
}
