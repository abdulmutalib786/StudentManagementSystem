package SMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SMS.entities.Students;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {

}
