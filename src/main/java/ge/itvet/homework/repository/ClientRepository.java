package ge.itvet.homework.repository;

import ge.itvet.homework.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
