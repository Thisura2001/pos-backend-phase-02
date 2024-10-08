package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Repository.ItemRepo;
import lk.ijse.posbackendphase02.Service.ItemService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private Mapping itemMapper;
    @Override
    public void saveItems(ItemDto itemDto) {
        itemRepo.save(itemMapper.ToItemEntity(itemDto));
    }
}
