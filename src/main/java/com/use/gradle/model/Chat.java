package com.use.gradle.model;

import lombok.Data;

@Data
public class Chat {
    private MessageType type;
    private String content;
    private String sender;
}
