package com.kairos.starConnect.repository;

import com.kairos.starConnect.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findTop50ByOrderByTimestampDesc();
    List<Message> findAllByOrderByTimestampAsc();
}
