package lk.ijse.posbackendphase02.Dto.Impl;

import lk.ijse.posbackendphase02.Dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto implements CustomerStatus {
    private String id;
    private String name;
    private String salary;
    private String address;
    private List<OrderDto> orderDtoList;
}
