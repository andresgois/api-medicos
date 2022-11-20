package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}