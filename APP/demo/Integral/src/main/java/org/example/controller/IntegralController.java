package org.example.controller;

import org.example.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class IntegralController {
    @Autowired
    private ScoringService scoringService;

    //新增积分
    @PostMapping("/Integral")
    public int updateIntegral(@RequestParam int pid, @RequestParam String money){
        //模拟业务逻辑处理时长
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return scoringService.insertScoring(pid,money);
    }
}
