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
@Table(name = "Customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String salary;
    private String address;
}
