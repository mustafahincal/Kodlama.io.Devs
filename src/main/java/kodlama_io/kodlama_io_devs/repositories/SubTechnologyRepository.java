package kodlama_io.kodlama_io_devs.repositories;

import kodlama_io.kodlama_io_devs.entities.SubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTechnologyRepository extends JpaRepository<SubTechnology,Integer> {
}
