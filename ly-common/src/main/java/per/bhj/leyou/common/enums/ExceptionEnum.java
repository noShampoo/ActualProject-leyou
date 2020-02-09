package per.bhj.leyou.common.enums;

//import jdk.nashorn.internal.objects.annotations.Getter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNT_BE_NO(400, "价格不能为空22222")
    ;
    private int code;
    private String msg;
}
