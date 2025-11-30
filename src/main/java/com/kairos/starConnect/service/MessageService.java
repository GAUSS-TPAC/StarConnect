package com.kairos.starConnect.service;

import com.kairos.starConnect.entities.Message;
import com.kairos.starConnect.repository.MessagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessagesRepository messagesRepository;

    public Message saveMessage(Message message){
        return messagesRepository.save(message);
    }

    public List<Message> getAllMessages(){
        return messagesRepository.findAllByOrderByTimestampAsc();
    }

    public List<Message> getRecentMessage(){
        return messagesRepository.findTop50ByOrderByTimestampDesc();
    }
}
