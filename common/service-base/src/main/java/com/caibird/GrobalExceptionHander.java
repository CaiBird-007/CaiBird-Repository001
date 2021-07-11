package com.caibird;


import com.caibird.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GrobalExceptionHander {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出现异常啦");

    }

    @ExceptionHandler(CaiBirdException.class)
    @ResponseBody
    public R error(CaiBirdException e){
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());

    }
}
