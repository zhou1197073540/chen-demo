package com.exa.demo.example.dbDemo.mappers;

import com.exa.demo.POJO.PageData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

//@Mapper
@Component
public interface TestDao {


    Integer getTotalCount();

    @Select("select count(*) from h_cc_cdr")
    Integer getCount();


    @Insert("insert into my_test_table(message_id,message_content,time_stamp) " +
            "values (#{message_id},#{message_content},#{time_stamp})")
    int saveDemo(PageData pd);
}
