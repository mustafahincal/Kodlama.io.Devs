package kodlama_io.kodlama_io_devs.services.abstracts;

import kodlama_io.kodlama_io_devs.entities.ProgrammingLanguage;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageAddRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageDeleteRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageUpdateRequest;

import java.util.List;

public interface ProgrammingLanguageService {
    List<ProgrammingLanguage> getAll();
    void add(ProgrammingLanguageAddRequest programmingLanguageAddRequest);
    void delete(ProgrammingLanguageDeleteRequest programmingLanguageDeleteRequest);
    void update(ProgrammingLanguageUpdateRequest programmingLanguageUpdateRequest);
}
