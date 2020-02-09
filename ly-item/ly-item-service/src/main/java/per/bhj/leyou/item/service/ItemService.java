package per.bhj.leyou.item.service;

import org.springframework.stereotype.Service;
import per.bhj.leyou.item.pojo.Item;

import java.util.Random;

@Service
public class ItemService {
    public Item saveItem(Item item) {
        int id = new Random().nextInt(100);
        item.setId(id);
        return item;
    }
}
