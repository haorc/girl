package com.imooc.girl.impl;

import com.imooc.girl.dao.GirlRepository;
import com.imooc.girl.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by haorc ON 2018/5/12
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * Transactional启用事物
     */
    @Transactional
    public void insertTwo() {
        Girl girl = new Girl();
        girl.setAge(15);
        girl.setCupSize("A");
        this.girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(15);
        girl2.setCupSize("A");
        this.girlRepository.save(girl2);
    }
}
