package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.CustomStatusCodes.StatusCodes;
import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Exception.OrderNotFoundException;
import lk.ijse.posbackendphase02.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    static Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveOrder(@RequestBody OrderDto orderDto){
        try {
            System.out.println(orderDto);
            orderService.saveOrder(orderDto);
            logger.info("Order Added");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Order Not Added");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/new-order-id")
    public ResponseEntity<?> getNewOrderId() {
        String newOrderId = orderService.generateNewOrderId();
        return ResponseEntity.ok().body(newOrderId);
    }
    @GetMapping("/{orderId}")
    public OrderStatus getOrderById(@PathVariable ("orderId") String orderId){
        logger.info("Order Retrieved");
        return orderService.getOrderById(orderId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto>getAllOrders(){
        return orderService.getAllOrders();
    }
}