package org.example.util;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MqConnectUtil {

    /**
     * 获取mq的连接
     * @return
     * @throws TimeoutException
     * @throws IOException
     */
    public static Connection getMqConnection() throws IOException, TimeoutException{
        //1、定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2、设置连接地址等信息
        factory.setHost("127.0.0.1");
        //amqp协议端口
        factory.setPort(5672);
        //设置具体的vhost(想象成数据库)
        factory.setVirtualHost("/xiaoxiaohu");
        //设置用户名密码信息
        factory.setUsername("xiaoxiaohu");
        factory.setPassword("123456");

        return factory.newConnection();
    }
}
