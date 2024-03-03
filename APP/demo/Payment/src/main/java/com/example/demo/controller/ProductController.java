package com.example.demo.controller;

import com.example.demo.client.IntegralClient;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.ScoringMapper;
import com.example.demo.po.ProductPo;
import com.example.demo.po.ScoringPo;
import com.example.demo.service.ScoringService;
import com.example.demo.utility.DiscountClass;
import com.example.demo.utility.LogExecutionTime;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ScoringMapper scoringMapper;

    @Autowired
    private ScoringService scoringService;
    
    @Autowired
    private IntegralClient integralClient;

    @GetMapping("/product")
    @LogExecutionTime
    public ArrayList<ProductPo> getproductAll(){
        ArrayList<ProductPo> arrayList = productMapper.selectProductAll();
        return arrayList;
    }

    /**
     * 根据id修改商品数量
     * @param id
     * @param quantity
     * @return ProductPo
     */
    @PostMapping("/product")
    @LogExecutionTime //方法被调用时，注解处理器执行相应逻辑
    public String updateProduct(@RequestParam int id,@RequestParam String quantity ,@RequestParam String money
    ){
        int updateResult = productMapper.updateProduct(id,quantity);
        ProductPo productPo = productMapper.selectProduct(id);
        if (updateResult == 1 && productPo.getQuantity() > 0){
            //优惠后的金额
            double discountsMoney = Double.parseDouble(money) * DiscountClass.getDiscount1();
            //新增对应商品的积分
//            int insertScoring = scoringService.insertScoring(id,money);
//            int insertScoring = integralClient.updateIntegral(id, money);
//            System.out.println(insertScoring);
            //向RabbitMq发送新增积分模块的参数消息
            Map<String, Object> msg = new HashMap<>();
            msg.put("pid",id);
            msg.put("amount",money);
            rabbitTemplate.convertAndSend("object.queue",msg);
            return "支付成功,优惠后的金额为：" + String.valueOf(discountsMoney);
        }else {
            return "支付失败";
        }

    }
}
