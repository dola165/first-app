package ge.itvet.homework.repository;

import ge.itvet.homework.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
