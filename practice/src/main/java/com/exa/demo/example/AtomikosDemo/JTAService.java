package com.exa.demo.example.AtomikosDemo;

import com.exa.demo.POJO.PageData;
import com.exa.demo.example.AtomikosDemo.mappers.member.MemberMapper;
import com.exa.demo.example.AtomikosDemo.mappers.memberInfo.MemberInfoMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

public class JTAService {

    @Resource
    private MemberMapper memberMapper;//操作35库
    @Resource
    private MemberInfoMapper memberInfoMapper;//操作15库

    @Transactional
    public void saveMulDataSource(){

        PageData pd = new PageData();
        pd.put("keyword", "周同学");
        pd.put("cookie", "7777");
        memberMapper.save46ReadWrite(pd);

//        int i=1/0;
        PageData pageData = memberInfoMapper.select46ReadOnly();
        System.out.println(pageData.toString());
    }

}
