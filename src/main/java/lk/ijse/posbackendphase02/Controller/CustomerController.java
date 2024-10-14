package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.CustomStatusCodes.StatusCodes;
import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.Impl.CustomerDto;
import lk.ijse.posbackendphase02.Exception.CustomerNotFoundException;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Service.CustomerService;
import lk.ijse.posbackendphase02.Util.RegexProcess;
import org.hibernate.type.descriptor.sql.internal.Scale6IntervalSecondDdlType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDto customerDto){
        try {
            customerService.saveCustomer(customerDto);
//            logger.info("Customer Added");
            return new ResponseEntity<>(HttpStatus.CREATED);


        }catch (DataPersistException e){
//            logger.warn("Customer Not Added");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
//            logger.error("Customer Not Added");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getCustomerById(@PathVariable ("customerId") String customerId){
        CustomerStatus customerById = customerService.getCustomerById(customerId);
//        logger.info("Customer Retrieved");
        return customerById;

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto>getAllCustomer(){
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
//        logger.info("Customer Retrieved");
        return allCustomers;
    }
    @PutMapping(value = "/{customerId}")
    public ResponseEntity<Void> UpdateCustomer(@PathVariable("customerId") String customerId, @RequestBody CustomerDto customerDto) {
        try {
            customerService.UpdateCustomer(customerId, customerDto);
            logger.info("Customer Updated");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content for success
        } catch (CustomerNotFoundException e) {
            logger.warn("Customer Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found for non-existent customer
        } catch (Exception e) {
            logger.error("Customer Not Updated");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error for general errors
        }
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Void> DeleteCustomer(@PathVariable ("customerId") String customerId){
        try {
            customerService.DeleteCustomer(customerId);
            logger.info("Customer Deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            logger.warn("Customer Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Customer Not Deleted");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
