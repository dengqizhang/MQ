package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.po.ScoringPo;

import java.util.ArrayList;

@Mapper
public interface ScoringMapper {

    int insertScoring(@Param("pid") int pid, @Param("amount") String amount);
}
