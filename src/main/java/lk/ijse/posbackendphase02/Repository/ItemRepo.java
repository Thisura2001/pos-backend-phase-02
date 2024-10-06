package lk.ijse.posbackendphase02.Repository;

import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity,String> {
}
