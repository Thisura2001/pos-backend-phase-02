package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.CustomStatusCodes.StatusCodes;
import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Exception.ItemNotFoundException;
import lk.ijse.posbackendphase02.Service.ItemService;
import lk.ijse.posbackendphase02.Util.RegexProcess;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItems(@RequestBody ItemDto itemDto){
        try {
            itemService.saveItems(itemDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getItemById(@PathVariable ("itemId") String itemId){
        return itemService.getItemById(itemId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDto>getAllItems(){
        return itemService.getAllItems();
    }
}
