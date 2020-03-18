package com.exa.demo.example.AtomikosDemo.mappers.memberInfo;

import com.exa.demo.POJO.PageData;
import com.exa.demo.example.AtomikosDemo.MemberInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Component
@Mapper
public interface MemberInfoMapper {
	@Insert("insert into member_info (id, nickname, realname, age) values (#{id},#{nickname},#{realname},#{age})")
    int insert(MemberInfo record);

    @Insert("insert into qmessage(message_id,message_content,time_stamp) " +
            "values (#{message_id},#{message_content},#{time_stamp})")
    int saveDemo(PageData pds);

    @Select("SELECT * FROM tnews_info LIMIT 1")
    PageData selectAll();

    @Select("SELECT * FROM qmessage LIMIT 1")
    PageData selectAlls();

    @Select("SELECT * FROM `tnews_info_bak` LIMIT 1")
    PageData select46ReadOnly();
}