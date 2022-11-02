package kodlama_io.kodlama_io_devs.services.concretes;

import kodlama_io.kodlama_io_devs.entities.ProgrammingLanguage;
import kodlama_io.kodlama_io_devs.repositories.ProgrammingLanguageRepository;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageAddRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageDeleteRequest;
import kodlama_io.kodlama_io_devs.requests.ProgrammingLanguageUpdateRequest;
import kodlama_io.kodlama_io_devs.services.abstracts.ProgrammingLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    ProgrammingLanguageRepository programmingLanguageRepository;
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository){
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return this.programmingLanguageRepository.findAll();
    }

    @Override
    public void add(ProgrammingLanguageAddRequest programmingLanguageAddRequest) {
        if(programmingLanguageAddRequest.getProgrammingLanguageName() == ""){
            System.out.println("Programlama dili ismi boş geçilemez");
        }else if(this.programmingLanguageRepository.getByprogrammingLanguageName(programmingLanguageAddRequest.getProgrammingLanguageName()) == null){
            System.out.println("Aynı isimde programlama dili eklenemez");
        }else{
            ProgrammingLanguage programmingLanguageToAdd = new ProgrammingLanguage();
            programmingLanguageToAdd.setProgrammingLanguageName(programmingLanguageAddRequest.getProgrammingLanguageName());
            this.programmingLanguageRepository.save(programmingLanguageToAdd);
        }
    }

    @Override
    public void delete(ProgrammingLanguageDeleteRequest programmingLanguageDeleteRequest) {
        this.programmingLanguageRepository.deleteById(programmingLanguageDeleteRequest.getId());
    }

    @Override
    public void update(ProgrammingLanguageUpdateRequest programmingLanguageUpdateRequest) {
        ProgrammingLanguage programmingLanguageToUpdate = this.programmingLanguageRepository.getById(programmingLanguageUpdateRequest.getId());

        programmingLanguageToUpdate.setProgrammingLanguageName(programmingLanguageUpdateRequest.getProgrammingLanguageName());
        this.programmingLanguageRepository.save(programmingLanguageToUpdate);
    }
}
