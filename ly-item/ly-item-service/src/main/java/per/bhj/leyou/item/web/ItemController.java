package per.bhj.leyou.item.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;
import per.bhj.leyou.item.pojo.Item;
import per.bhj.leyou.item.service.ItemService;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping()
    public ResponseEntity<Item> saveItem(Item item) {
        if (item.getPrice() == null) {
            throw new LyException(ExceptionEnum.PRICE_CANNT_BE_NO);
        }
        Item i = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
