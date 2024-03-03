package com.example.demo.client;

import org.springframework.stereotype.Component;

/**
 * 积分模块客户端的fallback
 */
@Component
public class IntegralClientFallback implements IntegralClient{
    @Override
    public int updateIntegral(int pid, String money) {
        return 6;
    }
}
