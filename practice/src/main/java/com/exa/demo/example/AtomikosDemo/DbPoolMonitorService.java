package com.exa.demo.example.AtomikosDemo;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import com.exa.demo.example.AtomikosDemo.mappers.member.MemberMapper;
import com.exa.demo.example.AtomikosDemo.mappers.memberInfo.MemberInfoMapper;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

public class DbPoolMonitorService implements ApplicationContextAware, CommandLineRunner {
    private ApplicationContext ac;
    private MemberMapper memberMapper;
    private MemberInfoMapper memberInfoMapper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext 。。。");
        this.ac=applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run bean 。。。");
        AtomikosNonXADataSourceBean dataSource01 = (AtomikosNonXADataSourceBean)ac.getBean("dataSource01");
        AtomikosNonXADataSourceBean dataSource02 = (AtomikosNonXADataSourceBean)ac.getBean("dataSource02");
        this.memberMapper= (MemberMapper) ac.getBean("memberMapper");
        this.memberInfoMapper= (MemberInfoMapper) ac.getBean("memberInfoMapper");
        while(true){
            try {
                dataSource01.setTestQuery("select 1");
                dataSource02.setTestQuery("select 1");
                int i=memberMapper.selectOne();
                int j=memberInfoMapper.selectOne();
                System.out.println(i+"=="+j);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                dataSource01.setTestQuery(null);
                dataSource02.setTestQuery(null);
            }
        }

    }
}
