package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.OrderDetailDto;
import lk.ijse.posbackendphase02.Repository.OrderDetailRepo;
import lk.ijse.posbackendphase02.Service.OrderDetailService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Transactional
public class OrderDetailImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private Mapping orderDetailMapping;

    @Override
    public void save(OrderDetailDto orderDetailDto) {
        orderDetailRepo.save(orderDetailMapping.ToOrderDetailEntity(orderDetailDto));
    }
}
