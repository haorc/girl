package com.imooc.girl.controller;

import com.imooc.girl.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haorc ON 2018/5/5
 * 1、支持将RequestMapping设置在类上，而不是方法上，这时请求的地址为【类RequestMappingUrl+方法RequestMapping】
 * 2、RequestMapping中的value支持多个值，一般不使用
 */
@RestController
@RequestMapping("/hi")
public class HelloController2 {

    @Value("${cupSize}")
    private String cupSize;//将配置文件application.yml中配置信息注入到变量中

    @Value("${age}")
    private Integer age;//配置文件不会设置属性类型，注入时会根据指定的类型自动转换

    @Value("${content}")
    private String contents;

    @Autowired
    private GirlProperties girlProperties; //需要在GirlProperties中增加@Componet

    @RequestMapping(value = {"/say","/say2"}, method = RequestMethod.GET)
    public String say(){
       //return "Hello Spring Boot!--" + cupSize + "_" + age; //方式一
        // return contents; //方式二
        return girlProperties.getCupSize(); //方式三
    }
}
