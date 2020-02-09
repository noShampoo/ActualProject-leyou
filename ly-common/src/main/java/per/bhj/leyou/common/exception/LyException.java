package per.bhj.leyou.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import per.bhj.leyou.common.enums.ExceptionEnum;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LyException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
