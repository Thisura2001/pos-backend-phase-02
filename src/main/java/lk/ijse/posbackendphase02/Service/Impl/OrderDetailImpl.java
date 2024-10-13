package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Dto.OrderDetailStatus;
import lk.ijse.posbackendphase02.Repository.OrderDetailRepo;
import lk.ijse.posbackendphase02.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public void save(OrderDetailDto orderDetailDto) {

    }
}
