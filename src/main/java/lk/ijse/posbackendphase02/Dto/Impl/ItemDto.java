package lk.ijse.posbackendphase02.Dto.Impl;

import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto implements ItemStatus {
    private String code;
    private String itemName;
    private String price;
    private String qty;
    private List<OrderDetailDto> orderDetails;
}
