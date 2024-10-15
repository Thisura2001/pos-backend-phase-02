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
@Table(name = "Customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String salary;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}

