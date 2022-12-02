package com.involveinnovation.Chatserver.controller.model;

import lombok.*;
//HERE WE USE LOMBOK, WE DON'T HAVE TO MAKE GETTER AND SETTERS
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Message {
    private String senderName;
    private String receiverName;

    private String message;
    private String date;

    private Status status;
}
