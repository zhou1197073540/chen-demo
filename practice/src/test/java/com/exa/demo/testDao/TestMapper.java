package com.exa.demo.testDao;

import com.exa.demo.DemoApplication;
import com.exa.demo.POJO.PageData;
import com.exa.demo.example.AtomikosDemo.mappers.member.MemberMapper;
import com.exa.demo.example.dbDemo.mappers.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={DemoApplication.class})// 指定启动类
public class TestMapper {

    @Autowired
    TestDao testDao;

    @Autowired
    MemberMapper memberMapper;

    @Test
    public void test2(){
        int totalCount = memberMapper.selectCount();
        System.out.println(totalCount);
    }

    @Test
    public void test1(){
        Integer totalCount = testDao.getCount();
        System.out.println(totalCount);
    }
}
