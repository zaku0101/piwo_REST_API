package com.mos.piwoCRUD.repository;

import com.mos.piwoCRUD.model.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByModuleQR(String qr);

    @Transactional
    void deleteByModuleQR(String qr);

    //maybe update by module QR implementation

}
