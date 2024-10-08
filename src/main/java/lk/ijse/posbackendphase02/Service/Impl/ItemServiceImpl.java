package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import lk.ijse.posbackendphase02.Repository.ItemRepo;
import lk.ijse.posbackendphase02.Service.ItemService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public ItemStatus getItemById(String itemId) {
        ItemEntity itemEntity = itemRepo.getReferenceById(itemId);
        return itemMapper.ToItemDto(itemEntity);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemEntity>itemEntities = itemRepo.findAll();
        return itemMapper.asItemDtoList(itemEntities);
    }
}
