package kodlama_io.kodlama_io_devs.services.concretes;

import kodlama_io.kodlama_io_devs.entities.SubTechnology;
import kodlama_io.kodlama_io_devs.repositories.SubTechnologyRepository;
import kodlama_io.kodlama_io_devs.requests.SubTechnologyAddRequest;
import kodlama_io.kodlama_io_devs.requests.SubTechnologyDeleteRequest;
import kodlama_io.kodlama_io_devs.requests.SubTechnologyUpdateRequest;
import kodlama_io.kodlama_io_devs.services.abstracts.SubTechnologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTechnologyManager implements SubTechnologyService {

    private SubTechnologyRepository subTechnologyRepository;

    public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository){
        this.subTechnologyRepository = subTechnologyRepository;
    }

    @Override
    public List<SubTechnology> getAll() {
        return this.subTechnologyRepository.findAll();
    }

    @Override
    public void add(SubTechnologyAddRequest subTechnologyAddRequest) {
        var subTechnologyToAdd = new SubTechnology();
        subTechnologyToAdd.setSubTechnologyName(subTechnologyAddRequest.getSubTechnologyName());
        this.subTechnologyRepository.save(subTechnologyToAdd);
    }

    @Override
    public void delete(SubTechnologyDeleteRequest subTechnologyDeleteRequest) {
        var subTechnologyToDelete = this.subTechnologyRepository.getById(subTechnologyDeleteRequest.getId());
        this.subTechnologyRepository.delete(subTechnologyToDelete);
    }

    @Override
    public void update(SubTechnologyUpdateRequest subTechnologyUpdateRequest) {
        var subTechnologyToUpdate = this.subTechnologyRepository.getById(subTechnologyUpdateRequest.getId());
        subTechnologyToUpdate.setSubTechnologyName(subTechnologyUpdateRequest.getSubTechnologyName());
        this.subTechnologyRepository.save(subTechnologyToUpdate);
    }
}
