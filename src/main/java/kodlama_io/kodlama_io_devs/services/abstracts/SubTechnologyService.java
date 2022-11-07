package kodlama_io.kodlama_io_devs.services.abstracts;

import kodlama_io.kodlama_io_devs.entities.SubTechnology;
import kodlama_io.kodlama_io_devs.requests.*;

import java.util.List;

public interface SubTechnologyService {
    List<SubTechnology> getAll();
    void add(SubTechnologyAddRequest subTechnologyAddRequest);
    void delete(SubTechnologyDeleteRequest subTechnologyDeleteRequest);
    void update(SubTechnologyUpdateRequest subTechnologyUpdateRequest);
}
