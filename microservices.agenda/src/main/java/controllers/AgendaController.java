package controllers;

import entities.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AgendaService;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @GetMapping("/getUsers")
    public List<Agenda> getUsers() {
        return agendaService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Agenda agenda){
        agendaService.save(agenda);
    }

    @DeleteMapping ("/delete/{id}")
    public void create(@PathVariable Long id){
        agendaService.deleteById(id);
    }

    @GetMapping("/search-by-role/{id}")
    public ResponseEntity<?> getAgendabyUser(@PathVariable Long userId){
        return  ResponseEntity.ok(agendaService.findByuserId(userId));
    }
}