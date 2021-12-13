package com.company.pr5.websocket;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "chat_messages")
public class dbMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "from_user")
    private String from;

    @Column(name = "text_of_message")
    private String text;

    @Column(name = "date_of_message")
    private String date;
}
