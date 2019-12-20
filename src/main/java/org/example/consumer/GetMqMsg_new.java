package org.example.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.example.util.MqConnectUtil;


public class GetMqMsg_new {
    private static String simpleQueueName = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection mqConnection = MqConnectUtil.getMqConnection();
        // 构建通道
        Channel createChannel = mqConnection.createChannel();
        //申明一个指定的队列
        createChannel.queueDeclare(simpleQueueName,
                false, false, false, null);
        //信访室接受消息
        DefaultConsumer consumer = new DefaultConsumer(createChannel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.err.println(" get msg new = " + message );
            }
        };
        //监听队列
        createChannel.basicConsume(simpleQueueName, true, consumer);
    }
}

