package kodlama_io.kodlama_io_devs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programming_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "subTechnologyList"})
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "programming_language_name")
    private String programmingLanguageName;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<SubTechnology> subTechnologyList;
}
