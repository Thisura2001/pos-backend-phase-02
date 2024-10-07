package lk.ijse.posbackendphase02.Util;

import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
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
    public CustomerEntity ToCustomerEntity(CustomerDto customerDto){//Converts a UserDto object into a UserEntity object.
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto ToCustomerDto(CustomerEntity customerEntity){//Converts a UserEntity object into a UserDto object.
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public List<CustomerDto> asCustomerDtoList(List<CustomerEntity> customerEntities){
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDto>>() {}.getType());
    }
}
