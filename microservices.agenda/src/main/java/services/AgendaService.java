package services;

import entities.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
        Optional<Agenda> optionalUser = agendaRepository.findById(id);
        return optionalUser.orElse(null);
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
}
