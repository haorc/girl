package com.imooc.girl.controller;

import com.imooc.girl.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haorc ON 2018/5/5
 * 1、
 * 2、将配置写到类里，三种方式，其中方式三是推荐的方式
 * 3、请求参数映射 say2函数
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;//将配置文件application.yml中配置信息注入到变量中

    @Value("${age}")
    private Integer age;//配置文件不会设置属性类型，注入时会根据指定的类型自动转换

    @Value("${content}")
    private String contents;

    @Autowired
    private GirlProperties girlProperties; //需要在GirlProperties中增加@Componet

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
       //return "Hello Spring Boot!--" + cupSize + "_" + age; //方式一
        // return contents; //方式二
        return girlProperties.getCupSize(); //方式三
    }

    @RequestMapping(value = "/hello2/{id}", method = RequestMethod.GET)
    public String say2(@PathVariable("id") Integer id){
        //return "Hello Spring Boot!--" + cupSize + "_" + age; //方式一
        // return contents; //方式二
        return "id = " + id; //方式三
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer iid){
        //return "Hello Spring Boot!--" + cupSize + "_" + age; //方式一
        // return contents; //方式二
        return "iid = " + iid; //方式三
    }
}
