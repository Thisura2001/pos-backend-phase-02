package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orderDetails")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        try {
            System.out.println(orderDetailDto);
            orderDetailService.save(orderDetailDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
