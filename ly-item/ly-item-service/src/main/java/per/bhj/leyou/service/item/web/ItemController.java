package per.bhj.leyou.service.item.web;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.bhj.leyou.item.pojo.Item;
import per.bhj.leyou.service.item.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping()
    public ResponseEntity<Item> saveItem(Item item) {
        if (item.getPrice() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Item i = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
