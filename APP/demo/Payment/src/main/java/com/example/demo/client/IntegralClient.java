package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 积分模块远程调用客户端
 */
@FeignClient(name = "Integral-server",fallback =IntegralClientFallback.class )
public interface IntegralClient {

    //新增积分
    @PostMapping("/Integral")
    int updateIntegral(@RequestParam("pid") int pid, @RequestParam("money") String money);

}
