package com.nonegger.platform.smallroutine.handler;

import com.nonegger.platform.smallroutine.entity.AreaEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * @author Eric
 * @date 2018/7/10 22:32
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handlerException(HttpServletRequest request, Exception e) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("errMsg", e.getMessage());
        modelMap.put("status", "FAIL");
        //modelMap.put("request", request);
        return modelMap;
    }

}
