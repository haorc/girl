package com.imooc.girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by haorc ON 2018/5/12
 */
//获取配置文件application.yml中前缀是girl的配置信息
@ConfigurationProperties(prefix = "girl")
@Component
public class GirlProperties {
    private String cupSize;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}
