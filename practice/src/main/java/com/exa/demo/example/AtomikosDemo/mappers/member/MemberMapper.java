package com.exa.demo.example.AtomikosDemo.mappers.member;

import com.exa.demo.POJO.PageData;
import com.exa.demo.example.AtomikosDemo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

//@Mapper
@Component
public interface MemberMapper {
	@Insert("insert into member (id, username, password,status) VALUES(#{id},#{username},#{password},#{status})")
    int insert(Member record);

    @Select("select count(*) from h_cc_cdr")
    int selectCount();


    @Insert("insert into my_test_table(message_id,message_content,time_stamp) " +
            "values (#{message_id},#{message_content},#{time_stamp})")
    int saveDemo(PageData pd);

    @Insert("INSERT INTO tnews_info_bak(keyword,cookie) VALUES(#{keyword},#{cookie});")
    void save46ReadWrite(PageData pd);
}