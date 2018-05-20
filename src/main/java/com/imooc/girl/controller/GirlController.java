package com.imooc.girl.controller;

import com.imooc.girl.dao.GirlRepository;
import com.imooc.girl.entity.Girl;
import com.imooc.girl.impl.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by haorc ON 2018/5/12
 * 1、获取请求参数的注解
 * 2、获取请求路径中参数的注解
 * 3、@RequestMapping的GET、PUT等简写注解
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取所有的女生信息
     * @return 返回所有的girl信息
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls() {
        return girlRepository.findAll(); // 可以使用post满测试
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girlRepository.save(girl);
        return girl;
    }

    /**
     * 通过id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id) {
        Girl girl =  this.girlRepository.getOne(id);
        return girl;
    }

    /**
     * 通过age查询一个女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girlsa/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age) {
        return this.girlRepository.findByAge(age);
    }

    /**
     * 通过id更新一个女生
     * @param id
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age) {
        Girl girl = this.girlRepository.getOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        this.girlRepository.save(girl);
        return girl;
    }

    /**
     * 通过id删除一个女生
     * @param id
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public String delGirlById(@PathVariable("id") Integer id) {
        this.girlRepository.deleteById(id);
        return "del ok";
    }

    /**
     * 测试事物
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        this.girlService.insertTwo();
    }
}
