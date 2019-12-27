package cn.com.hohistar.tutorial.springboot.starter.exception;

import cn.com.hohistar.tutorial.springboot.starter.api.vo.ApiResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ApiResult.ApiResultBuilder builder = ApiResult.builder().succ(false).build().toBuilder();

        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());

        return handleExceptionInternal(exception, builder.msg(errorMsg).build(), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({BizException.class})
    public ResponseEntity<Object> handleBizException(BizException e, WebRequest request) {

        ApiResult.ApiResultBuilder builder = ApiResult.builder().succ(false).build().toBuilder();

        return new ResponseEntity<Object>(builder.msg(e.getMessage()).build(), new HttpHeaders(), HttpStatus.OK);

    }
}
