package com.mos.piwoCRUD.service;

import com.mos.piwoCRUD.dao.ModuleDAO;
import com.mos.piwoCRUD.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService(@Qualifier("postgres") TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
}
