package services;

import entities.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import repositorys.AgendaRepository;

import java.util.List;
import java.util.Optional;

public class AgendaService implements AgendaServiceImpl{

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda findById(Long id) {
        Optional<Agenda> buscarIdAgenda = agendaRepository.findById(id);
        return buscarIdAgenda.orElse(null);
    }

    @Override
    @Transactional
    public void save(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public List<Agenda> findByuserId(Long userId) {
        return (List<Agenda>) agendaRepository.findByUserId(userId);
    }

    @Autowired
    private RestTemplate restTemplate;

    public String callUserMicroservice() {
        String url = "http:/api/users";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}