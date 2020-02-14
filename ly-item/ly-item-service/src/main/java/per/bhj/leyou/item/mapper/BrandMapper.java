package per.bhj.leyou.item.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import per.bhj.leyou.item.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand(category_id, brand_id) values(#{cid}, #{bid});")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);
}
