package lk.ijse.posbackendphase02.CustomStatusCode;

import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lk.ijse.posbackendphase02.Dto.OrderDetailStatus;
import lk.ijse.posbackendphase02.Dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomStatusCode implements CustomerStatus, ItemStatus, OrderStatus, OrderDetailStatus {
}
