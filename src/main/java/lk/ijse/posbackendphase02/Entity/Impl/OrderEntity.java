package lk.ijse.posbackendphase02.Entity.Impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.posbackendphase02.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "Order")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String amount;
    private String netTotal;
    private String discount;
    private String finalTotal;
}
