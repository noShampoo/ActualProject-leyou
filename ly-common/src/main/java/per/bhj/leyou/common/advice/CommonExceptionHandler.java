package per.bhj.leyou.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;
import per.bhj.leyou.common.vo.ExceptionResult;

//默认情况下会拦截所有的Controller
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handleException(LyException e) {
        ExceptionEnum em = e.getExceptionEnum();
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(em));
    }
}
