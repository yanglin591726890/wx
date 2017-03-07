package com.zeroyoung.dao;

import com.zeroyoung.entity.Media;
import com.zeroyoung.entity.MediaExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MediaMapper {
    int countByExample(MediaExample example);

    int deleteByExample(MediaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Media record);

    int insertSelective(Media record);

    List<Media> selectByExample(MediaExample example);

    Media selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByExample(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);
}