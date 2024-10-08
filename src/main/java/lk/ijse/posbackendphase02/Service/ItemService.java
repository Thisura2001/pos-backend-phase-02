package lk.ijse.posbackendphase02.Service;

import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.ItemStatus;

import java.util.List;

public interface ItemService {
    void saveItems(ItemDto itemDto);

    ItemStatus getItemById(String itemId);

    List<ItemDto> getAllItems();
}
