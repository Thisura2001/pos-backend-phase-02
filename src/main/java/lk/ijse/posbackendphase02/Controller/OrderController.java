package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDto;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Service.OrderService;
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveOrder(@RequestBody OrderDto orderDto){
        try {
            orderService.saveOrder(orderDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
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
    public OrderStatus getOrderStatus(@PathVariable ("orderId") String orderId){
        return orderService.getOrderById(orderId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto>getAllOrders(){
        return orderService.getAllOrders();
    }
}