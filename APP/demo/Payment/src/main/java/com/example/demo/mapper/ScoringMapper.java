package com.example.demo.mapper;

import com.example.demo.po.ProductPo;
import com.example.demo.po.ScoringPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface ScoringMapper {


    //获取所有商品积分
    ArrayList<ScoringPo> selectScoringAll();

    int insertScoring(@Param("pid") int pid, @Param("amount") String amount);
}
