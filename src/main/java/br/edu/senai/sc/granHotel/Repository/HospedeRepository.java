package br.edu.senai.sc.granHotel.Repository;

import br.edu.senai.sc.granHotel.Entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    List<Hospede> findByNomeContaining(String nome);
}
