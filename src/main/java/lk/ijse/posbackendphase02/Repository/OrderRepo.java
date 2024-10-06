package lk.ijse.posbackendphase02.Repository;

import lk.ijse.posbackendphase02.Entity.Impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity,String> {
}
