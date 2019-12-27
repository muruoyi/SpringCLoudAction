package cn.com.hohistar.tutorial.springboot.starter.api.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @Classname ApiResult
 * @Description TODO
 * @Date 2019/7/11 2:16 PM
 * @Created by jini
 */

@Data
@Builder(toBuilder = true)
public class ApiResult {

    private boolean succ = false;
    private String code;
    private String msg;
    private Object data;

}
