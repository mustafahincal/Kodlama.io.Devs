package com.mustafahincal.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;

@Table(name = "sub_techologies")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubTechnology {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "programming_language_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProgrammingLanguage programmingLanguage;
}
