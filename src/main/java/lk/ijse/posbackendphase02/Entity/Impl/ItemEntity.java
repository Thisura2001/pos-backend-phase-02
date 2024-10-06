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
@Table(name = "Items")
public class ItemEntity implements SuperEntity {
    @Id
    private String code;
    private String itemName;
    private String price;
    private String qty;
}
