package lk.ijse.posbackendphase02.Repository;

import lk.ijse.posbackendphase02.Entity.Impl.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity,String> {
}
