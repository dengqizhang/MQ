package com.example.demo.service;

import com.example.demo.po.ScoringPo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ScoringService {
    int insertScoring(@Param("pid") int pid, @Param("amount") String amount);

}
