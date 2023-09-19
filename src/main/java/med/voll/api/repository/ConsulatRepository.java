package med.voll.api.repository;

import med.voll.api.domain.consulta.Consuta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulatRepository extends JpaRepository<Consuta, Long> {
}