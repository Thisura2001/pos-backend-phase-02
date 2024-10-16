package lk.ijse.posbackendphase02.Controller;

import lk.ijse.posbackendphase02.CustomStatusCodes.StatusCodes;
import lk.ijse.posbackendphase02.Dto.Impl.ItemDto;
import lk.ijse.posbackendphase02.Dto.ItemStatus;
import lk.ijse.posbackendphase02.Exception.DataPersistException;
import lk.ijse.posbackendphase02.Exception.ItemNotFoundException;
import lk.ijse.posbackendphase02.Service.ItemService;
import lk.ijse.posbackendphase02.Util.RegexProcess;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static Logger logger = LoggerFactory.getLogger(ItemController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveItems(@RequestBody ItemDto itemDto){
        try {
            itemService.saveItems(itemDto);
            logger.info("Item Added");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.warn("Item Not Added");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Item Not Added");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getItemById(@PathVariable ("itemId") String itemId){
        logger.info("Item Retrieved");
        return itemService.getItemById(itemId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDto>getAllItems(){
        return itemService.getAllItems();
    }
    @PutMapping(value = "/{itemId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItems(@RequestBody ItemDto itemDto,@PathVariable ("itemId") String itemId){
        try {
            itemService.updateItems(itemDto,itemId);
            logger.info("Item Updated");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<Void> DeleteItems(@PathVariable ("itemCode") String itemCode){
        try {
             itemService.DeleteItem(itemCode);
            logger.info("Item Deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            logger.warn("Item Not Found");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
