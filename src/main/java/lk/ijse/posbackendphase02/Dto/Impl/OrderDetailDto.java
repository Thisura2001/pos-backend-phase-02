package lk.ijse.posbackendphase02.Dto.Impl;

import lk.ijse.posbackendphase02.Dto.OrderDetailStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDto implements OrderDetailStatus {
    private String orderId;
    private String itemCode;
    private String qty;
    private String unitPrice;
    private String customerId;
    private String itemName;
}
