package kodlama_io.kodlama_io_devs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "sub_technologies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubTechnology {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sub_techology_name")
    private String subTechnologyName;

    @ManyToOne()
    @JoinColumn(name = "programming_language_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProgrammingLanguage programmingLanguage;

}
