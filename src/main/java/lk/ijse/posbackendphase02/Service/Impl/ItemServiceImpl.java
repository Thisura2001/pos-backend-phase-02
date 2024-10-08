package lk.ijse.posbackendphase02.Service.Impl;

import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lk.ijse.posbackendphase02.Entity.Impl.ItemEntity;
import lk.ijse.posbackendphase02.Exception.CustomerNotFoundException;
import lk.ijse.posbackendphase02.Repository.ItemRepo;
import lk.ijse.posbackendphase02.Service.ItemService;
import lk.ijse.posbackendphase02.Util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateItems(ItemDto itemDto, String itemId) {
        Optional<ItemEntity> byId = itemRepo.findById(itemId);
        if (!byId.isPresent()){
            throw new CustomerNotFoundException("Item Not Found !!");
        }else {
            byId.get().setItemName(itemDto.getItemName());
            byId.get().setPrice(itemDto.getPrice());
            byId.get().setQty(itemDto.getQty());
        }

    }

    @Override
    public void DeleteItem(String itemCode) {
         itemRepo.deleteById(itemCode);
    }
}
