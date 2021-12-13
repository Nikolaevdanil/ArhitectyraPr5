package com.company.pr5.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Sender {

    private dbMessageQuery dbMessageQuery;

    @Autowired
    public Sender(dbMessageQuery dbMessageQuery) {
        this.dbMessageQuery = dbMessageQuery;
    }

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        System.out.println(time);
        dbMessage dbMessage = new dbMessage();
        dbMessage.setFrom(message.getFrom());
        dbMessage.setText(message.getText());
        dbMessage.setDate(time);
        dbMessageQuery.save(dbMessage);
        return new OutputMessage(message.getFrom(),message.getText(), time);
    }
}
