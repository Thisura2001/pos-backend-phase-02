package lk.ijse.posbackendphase02.Service;

import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    CustomerStatus getCustomerById(String customerId);

    void UpdateCustomer(String customerId, CustomerDto customerDto);

    void DeleteCustomer(String customerId);
}
