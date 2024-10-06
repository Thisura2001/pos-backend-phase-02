package lk.ijse.posbackendphase02.Dto.Impl;

import jakarta.persistence.criteria.Order;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto implements OrderStatus {
    private String orderId;
    private String amount;
    private String netTotal;
    private String discount;
    private String finalTotal;
}
