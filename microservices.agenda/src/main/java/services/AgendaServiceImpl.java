package services;

import entities.Agenda;

import java.util.List;

public interface AgendaServiceImpl {
    List<Agenda> findAll();

    Agenda findById(Long id);

    void save(Agenda agenda);

    void deleteById(Long id);

    List<Agenda> findByuserId(Long userId);
}
