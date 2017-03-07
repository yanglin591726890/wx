package com.zeroyoung.dao;

import com.zeroyoung.entity.ShareCount;
import com.zeroyoung.entity.ShareCountExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShareCountMapper {
    int countByExample(ShareCountExample example);

    int deleteByExample(ShareCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareCount record);

    int insertSelective(ShareCount record);

    List<ShareCount> selectByExample(ShareCountExample example);

    ShareCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareCount record, @Param("example") ShareCountExample example);

    int updateByExample(@Param("record") ShareCount record, @Param("example") ShareCountExample example);

    int updateByPrimaryKeySelective(ShareCount record);

    int updateByPrimaryKey(ShareCount record);

    int updateCount(ShareCount record);
}