package lk.ijse.posbackendphase02.Entity.Impl;

import jakarta.persistence.*;
import lk.ijse.posbackendphase02.Entity.SuperEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String amount;
    private String netTotal;
    private String discount;
    private String finalTotal;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetails;
}
