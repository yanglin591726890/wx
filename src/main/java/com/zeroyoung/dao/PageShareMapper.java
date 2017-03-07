package com.zeroyoung.dao;

import com.zeroyoung.entity.PageShare;
import com.zeroyoung.entity.PageShareExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PageShareMapper {
    int countByExample(PageShareExample example);

    int deleteByExample(PageShareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageShare record);

    int insertSelective(PageShare record);

    List<PageShare> selectByExample(PageShareExample example);

    PageShare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageShare record, @Param("example") PageShareExample example);

    int updateByExample(@Param("record") PageShare record, @Param("example") PageShareExample example);

    int updateByPrimaryKeySelective(PageShare record);

    int updateByPrimaryKey(PageShare record);
}