package cn.com.hohistar.tutorial.springboot.starter.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname ApiResult
 * @Description TODO
 * @Date 2019/7/11 2:16 PM
 * @Created by jini
 */

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {

    private boolean succ = false;
    private String code;
    private String msg;
    private T data;

}
