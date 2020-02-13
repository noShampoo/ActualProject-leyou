package per.bhj.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;
import per.bhj.leyou.common.vo.PageResult;
import per.bhj.leyou.item.mapper.BrandMapper;
import per.bhj.leyou.item.pojo.Brand;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page,
                                              Integer rows,
                                              String sortBy,
                                              Boolean desc,
                                              String key) {
        //分页
        PageHelper.startPage(page, rows);
        //条件过滤
        /**
         * where 'name' like "%x%" or letter="x" order by id desc;
         */
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            //通过createCriteria()创建条件
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if (StringUtils.isNoneBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> brandList = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }

        //解析分页结果
        PageInfo<Brand> pageInfo = new PageInfo(brandList);
        return new PageResult<>(pageInfo.getTotal(), brandList);
    }
}
