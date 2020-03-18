package com.exa.demo.example.swaggerDemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Api("用户操作接口")
@RequestMapping("/admin")
@Controller
public class SwaggerController {

    @ApiOperation(value = "获取otp", notes="通过手机号获取OTP验证码")
    @ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = true, dataType = "Integer")
    @RequestMapping(value = "test", method= RequestMethod.GET)
    @ResponseBody
    public String test(String telephone){
        System.out.println("....test...");
        return "success。。。";
    }

    @RequestMapping(value = "/index", method= RequestMethod.GET)
    public String index(){
        System.out.println("....index...");
        return "index";
    }

}
