package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import lk.ijse.posbackendphase02.Exception.CustomerNotFoundException;
import lk.ijse.posbackendphase02.Repository.CustomerRepo;
import lk.ijse.posbackendphase02.Service.CustomerService;
import lk.ijse.posbackendphase02.Util.AppUtil;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerRepo.save(customerMapping.ToCustomerEntity(customerDto));
    }

    @Override
    public CustomerStatus getCustomerById(String customerId) {
        CustomerEntity customerEntity = customerRepo.getReferenceById(customerId);
        return customerMapping.ToCustomerDto(customerEntity);
    }

    @Override
    public void UpdateCustomer(String customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> byId = customerRepo.findById(customerId);
        if (!byId.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found !!");
        }else {
            byId.get().setName(customerDto.getName());
            byId.get().setSalary(customerDto.getSalary());
            byId.get().setAddress(customerDto.getAddress());
        }
    }

    @Override
    public void DeleteCustomer(String customerId) {
        customerRepo.deleteById(customerId);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity>customerEntities = customerRepo.findAll();
        return customerMapping.asCustomerDtoList(customerEntities);
    }
}
