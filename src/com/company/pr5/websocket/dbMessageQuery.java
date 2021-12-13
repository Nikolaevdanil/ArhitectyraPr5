package com.company.pr5.websocket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface dbMessageQuery extends JpaRepository<dbMessage, Long> {
}
