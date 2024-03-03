package org.example.service.impl;

import org.apache.ibatis.annotations.Param;
import org.example.mapper.ScoringMapper;
import org.example.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoringServiceImpl implements ScoringService {

    @Autowired
    private ScoringMapper scoringMapper;
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
