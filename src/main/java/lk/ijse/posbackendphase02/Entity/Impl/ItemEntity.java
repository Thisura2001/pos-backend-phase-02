package lk.ijse.posbackendphase02.Entity.Impl;

import jakarta.persistence.*;
import lk.ijse.posbackendphase02.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "Items")
public class ItemEntity implements SuperEntity {
    @Id
    private String code;
    private String itemName;
    private String price;
    private String qty;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetails;
}
