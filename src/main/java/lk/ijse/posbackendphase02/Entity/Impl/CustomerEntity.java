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
@Table(name = "Customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String salary;
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;
}
