package per.bhj.leyou.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;
import per.bhj.leyou.item.mapper.SpecificationMapper;
import per.bhj.leyou.item.pojo.Specification;

import java.util.List;

@Service
public class SpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;

    public List<Specification> querySpecificationById(Long id) {
        //查询条件
        Specification specification = new Specification();
        specification.setCategoryId(id);
        //开始查询
        List<Specification> specificationList = specificationMapper.select(specification);
        if (CollectionUtils.isEmpty(specificationList)) {
            //没查到对应的商品规格组
            throw new LyException(ExceptionEnum.SPECIFICATION_NOT_FOUND);
        }
        return specificationList;
    }

//    public List<Specification> queryParamByList(Long gid, Long cid) {
//        return null;
//    }
}
