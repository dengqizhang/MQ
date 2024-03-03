package org.example.client;

import org.example.service.ScoringService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息队列消费者处理器
 */
@Component
public class ListenerClient {
    @Autowired
    private ScoringService scoringService;

    //简单消息模型
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg){
        System.out.println("spring消费者接收到消息：" + msg);
    }
    //订阅发布消息模型
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg){
        System.out.println("queue1接收到消息：" + msg);
    }
    //订阅发布消息模型
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg){
        System.out.println("queue2接收到消息：" + msg);
    }
    //json序列化
    @RabbitListener(queues = "object.queue")
    public void ObjectFanoutQueue2(Map<String,Object> msg){
        System.out.println("object.queue接收到消息：" + msg);
        //从消息中取出对应的参数
        String amount = (String) msg.get("amount");
        int pid = (int) msg.get("pid");

        int i = scoringService.insertScoring(pid, amount);
        System.out.println(i);

    }
}
