package per.bhj.leyou.item.service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;
import per.bhj.leyou.item.mapper.CategoryMapper;
import per.bhj.leyou.item.pojo.Category;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
//        通过select(T t)来查找，Mapper以t这个对象得非空字段为条件，比如说这里会生成一条以pid为sql语句来进行查询
        List<Category> categoryList = categoryMapper.select(category);
//        if (categoryList == null || categoryList.isEmpty())
        if (CollectionUtils.isEmpty(categoryList)) {
//            注：REST风格中未查到需要返回404
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return categoryList;
    }
}
