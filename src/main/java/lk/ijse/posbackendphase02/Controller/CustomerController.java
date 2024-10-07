package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.CustomStatusCodes.StatusCodes;
import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Exception.CustomerNotFoundException;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Service.CustomerService;
import lk.ijse.posbackendphase02.Util.RegexProcess;
import org.hibernate.type.descriptor.sql.internal.Scale6IntervalSecondDdlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDto customerDto){
        try {
            customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getCustomerById(@PathVariable ("customerId") String customerId){
        if (!RegexProcess.CustomerIdMatcher(customerId)){
            return new StatusCodes(1,"Customer Id not matched !!");
        }
        return customerService.getCustomerById(customerId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto>getAllCustomer(){
        return customerService.getAllCustomers();
    }
    @PutMapping(value = "/{customerId}")
    public ResponseEntity<Void>UpdateCustomer(@PathVariable ("customerId") String customerId,@RequestBody CustomerDto customerDto){
        try {
            if (!RegexProcess.CustomerIdMatcher(customerId) || customerDto == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.UpdateCustomer(customerId,customerDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void> DeleteCustomer(@PathVariable ("customerId") String customerId){
        try {
            if (!RegexProcess.CustomerIdMatcher(customerId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.DeleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
