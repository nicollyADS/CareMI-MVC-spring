package br.com.mapped.caremi.repository;

import br.com.mapped.caremi.model.Atendimento;
import br.com.mapped.caremi.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByNomeContainingIgnoreCase(String nome);
}
