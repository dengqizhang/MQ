package com.example.demo.service.impl;

import com.example.demo.mapper.ScoringMapper;
import com.example.demo.po.ScoringPo;
import com.example.demo.service.ScoringService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScoringServiceImpl implements ScoringService {

    @Autowired
    private ScoringMapper scoringMapper;
//    @Override
//    public ArrayList<ScoringPo> selectScoringAll() {
//        ArrayList<ScoringPo> scoringPos = scoringMapper.selectScoringAll();
//        //模拟业务逻辑处理时长
//        try{
//            Thread.sleep(2000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        return scoringPos;
//    }

    @Override
    public int insertScoring(@Param("pid") int pid, @Param("amount") String amount) {
        //模拟业务逻辑处理时长
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return scoringMapper.insertScoring(pid,amount);
    }
}
