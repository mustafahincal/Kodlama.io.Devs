package kodlama_io.kodlama_io_devs.repositories;

import kodlama_io.kodlama_io_devs.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Integer> {
    public ProgrammingLanguage getByprogrammingLanguageName(String name);
}
