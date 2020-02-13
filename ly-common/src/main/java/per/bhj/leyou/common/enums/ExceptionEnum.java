package per.bhj.leyou.common.enums;

//import jdk.nashorn.internal.objects.annotations.Getter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNT_BE_NO(400, "价格不能为空22222"),
    CATEGORY_NOT_FOUND(404, "商品分类没有查到"),
    BRAND_NOT_FOUND(404, "品牌没有查到"),
    ;
    private int code;
    private String msg;
}
