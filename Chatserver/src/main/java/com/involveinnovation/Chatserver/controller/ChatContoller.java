package com.involveinnovation.Chatserver.controller;

import com.involveinnovation.Chatserver.controller.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatContoller {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; // this will help us for the dynamic creation of send to

    @MessageMapping("/message") // This is for the public message path
    @SendTo("/chatroom/public") // this is going to send the messages on to the public server

    public Message receivePublicMessage(@Payload Message message) {
        return message;
    }
    @MessageMapping("/private-message") // this is the private message which is located at /app/message
    public Message receivePrivateMessage(@Payload Message message) {
        // here we are not using @SendTo, so instead we'll use dynamic send to:
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName() , "/private" , message); // it will directly take the user destination which we set in config file
        System.out.println(message.toString());
        return message;
    }
}
