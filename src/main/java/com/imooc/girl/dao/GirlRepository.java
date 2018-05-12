package com.imooc.girl.dao;

import com.imooc.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by haorc ON 2018/5/12
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    /**
     * 不需要写实现类，会自动根据age查询数据
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
