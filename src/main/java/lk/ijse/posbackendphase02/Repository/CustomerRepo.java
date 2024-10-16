package lk.ijse.posbackendphase02.Repository;

import lk.ijse.posbackendphase02.Entity.Impl.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
