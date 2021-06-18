package com.chatapplication.data.repository;

import com.chatapplication.data.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
