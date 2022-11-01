//package com.example.FormService;
//
//import org.springframework.amqp.core.AmqpAdmin;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.context.annotation.Bean;
//
//public class RabbitmqConfiguration {
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        return new CachingConnectionFactory("localhost");
//    }
//    @Bean
//    public AmqpAdmin amqpAdmin(){
//        return new RabbitAdmin(connectionFactory());
//    }
//}
