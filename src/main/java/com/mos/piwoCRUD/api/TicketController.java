package com.mos.piwoCRUD.api;

import com.mos.piwoCRUD.exception.ResourceNotFoundException;
import com.mos.piwoCRUD.model.Ticket;
import com.mos.piwoCRUD.repository.ModuleRepository;
import com.mos.piwoCRUD.repository.TicketRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {
@Autowired
private ModuleRepository moduleRepository;
@Autowired
private TicketRepository ticketRepository;


@GetMapping("/modules/{moduleQR}/tickets")
    public ResponseEntity<List<Ticket>> getAllTicketsByModuleId(@PathVariable(value = "moduleQR") String qr) throws ResourceNotFoundException {
    if(!moduleRepository.existsById(qr))
        throw new ResourceNotFoundException("Not found module with given qr code: " + qr);

    List<Ticket> tickets = ticketRepository.findByModuleQR(qr);
    if(tickets.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(tickets, HttpStatus.OK);
}

@PostMapping("/modules/{moduleQR/tickets}")
    public ResponseEntity<Ticket> createTicket(@PathVariable(value = "moduleQR") String qr, @RequestBody Ticket ticketRequest) throws ResourceNotFoundException {
    Ticket ticket = moduleRepository.findById(qr).map(module -> {
        ticketRequest.setModule(module);
        return ticketRepository.save(ticketRequest);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found module with given qr code: " + qr));
    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
}
@PutMapping("/tickets/{id}")
ResponseEntity<Ticket> updateTicket(@PathVariable("id") Long id, @RequestBody Ticket ticketRequest) throws ResourceNotFoundException {
    Ticket ticket = ticketRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found ticket with id: " + id));

    ticket.setDescription(ticketRequest.getDescription());

    return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.OK);
}
@DeleteMapping("/tickets/{id}")
public ResponseEntity<HttpStatus> deleteTicket(@PathVariable("id") Long id) throws ResourceNotFoundException {
    ticketRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
@DeleteMapping("modules/{moduleQR/tickets}")
    public ResponseEntity<List<Ticket>> deleteAllTicketsOfModule(@PathVariable(value = "moduleQR") String qr) throws ResourceNotFoundException {
    if(!moduleRepository.existsById(qr)){
        throw new ResourceNotFoundException("Not found module with given qr code: " + qr);
    }
    ticketRepository.deleteByModuleQR(qr);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
