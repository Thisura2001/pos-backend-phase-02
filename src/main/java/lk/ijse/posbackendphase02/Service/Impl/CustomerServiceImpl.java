package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import lk.ijse.posbackendphase02.Repository.CustomerRepo;
import lk.ijse.posbackendphase02.Service.CustomerService;
import lk.ijse.posbackendphase02.Util.AppUtil;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerDto.setId(AppUtil.generateCustomerId());
        customerRepo.save(customerMapping.ToCustomerEntity(customerDto));
    }

    @Override
    public CustomerStatus getCustomerById(String customerId) {
        CustomerEntity customerEntity = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapping.ToCustomerDto(customerEntity);
    }
}
