package repositorys;

import entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findAll();

    Optional<Agenda> findById(Long id);

    List<Agenda> findByUserId(Long userId);

    void deleteById(Long id);

    Agenda save(Agenda agenda);

}
