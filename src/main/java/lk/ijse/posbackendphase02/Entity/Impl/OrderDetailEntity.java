package lk.ijse.posbackendphase02.Entity.Impl;

import jakarta.persistence.*;
import lk.ijse.posbackendphase02.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "OrderDetail")
public class OrderDetailEntity implements SuperEntity {
    @Id
    private Long id;
    private String orderId;
    private String itemCode;
    private String qty;
    private String unitPrice;
    private String customerId;
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code")
    private ItemEntity item;
}
