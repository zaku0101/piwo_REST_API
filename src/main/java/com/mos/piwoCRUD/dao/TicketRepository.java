package com.mos.piwoCRUD.dao;

import com.mos.piwoCRUD.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
