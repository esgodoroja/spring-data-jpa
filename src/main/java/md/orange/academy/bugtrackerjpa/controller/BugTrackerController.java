package md.orange.academy.bugtrackerjpa.controller;

import java.util.List;
import md.orange.academy.bugtrackerjpa.entity.Application;
import md.orange.academy.bugtrackerjpa.entity.Bug;
import md.orange.academy.bugtrackerjpa.entity.Enhancement;
import md.orange.academy.bugtrackerjpa.entity.Release;
import md.orange.academy.bugtrackerjpa.entity.Ticket;
import md.orange.academy.bugtrackerjpa.service.IApplicationService;
import md.orange.academy.bugtrackerjpa.service.IBugService;
import md.orange.academy.bugtrackerjpa.service.IEnhancementService;
import md.orange.academy.bugtrackerjpa.service.IReleaseService;
import md.orange.academy.bugtrackerjpa.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class BugTrackerController {

  @Autowired
  private IApplicationService applicationService;

  @Autowired
  private ITicketService ticketService;

  @Autowired
  private IReleaseService releaseService;

  @Autowired
  private IBugService bugService;

  @Autowired
  private IEnhancementService enhancementService;

  @PostMapping("/enhancement")
  public ResponseEntity<Void> addEnhancement(@RequestBody Enhancement enhancement,
      UriComponentsBuilder builder) {
    enhancementService.addEnhancement(enhancement);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/enhancement").buildAndExpand(enhancement.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PostMapping("/bug")
  public ResponseEntity<Void> addBug(@RequestBody Bug bug, UriComponentsBuilder builder) {
    bugService.addBug(bug);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/bug").buildAndExpand(bug.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PostMapping("/application")
  public ResponseEntity<Void> addApplication(@RequestBody Application application,
      UriComponentsBuilder builder) {
    boolean flag = applicationService.addApplication(application);
    if (!flag) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    HttpHeaders headers = new HttpHeaders();
    headers
        .setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping("/application/{id}")
  public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id) {
    Application app = applicationService.getApplicationById(id);
    return new ResponseEntity<>(app, HttpStatus.OK);
  }

  @GetMapping("/application/name/{name}")
  public ResponseEntity<Application> getApplicationByName(
      @PathVariable(value = "name") String name) {
    Application app = applicationService.getApplicationByName(name)
        .orElse(new Application());
    return new ResponseEntity<>(app, HttpStatus.OK);
  }

  @PutMapping("/application")
  public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
    applicationService.updateApplication(application);
    return new ResponseEntity<>(application, HttpStatus.OK);
  }

  @DeleteMapping("/application/{id}")
  public ResponseEntity<Void> deleteApplication(@PathVariable("id") Integer id) {
    applicationService.deleteApplication(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/ticket/{id}")
  public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id) {
    Ticket ticket = ticketService.getTicketById(id);
    return new ResponseEntity<>(ticket, HttpStatus.OK);

  }

  @GetMapping("/tickets")
  public ResponseEntity<List<Ticket>> getAllTickets() {
    List<Ticket> list = ticketService.getAllTickets();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("/ticket")
  public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket, UriComponentsBuilder builder) {
    ticketService.addTicket(ticket);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/ticket")
  public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
    ticketService.updateTicket(ticket);
    return new ResponseEntity<>(ticket, HttpStatus.OK);
  }

  @DeleteMapping("/ticket/{id}")
  public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id) {
    ticketService.deleteTicket(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/ticket/{id}")
  public ResponseEntity<Ticket> closeTicket(@PathVariable("id") Integer id) {
    ticketService.closeTicket(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/release")
  public ResponseEntity<Void> addRelease(@RequestBody Release release,
      UriComponentsBuilder builder) {
    releaseService.addRelease(release);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(builder.path("/release").buildAndExpand(release.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping("/release/{appid}/{releaseid}")
  public ResponseEntity<Void> addApptoRelease(@PathVariable("appid") Integer appid,
      @PathVariable("releaseid") Integer releaseid, UriComponentsBuilder builder) {
    releaseService.addApplication(appid, releaseid);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}

