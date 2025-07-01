package com.nebulosa.clinica_estelar.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animal")
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "animal_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    @JsonBackReference
    private Tutor tutor;

    @OneToMany(mappedBy = "animal")
    @JsonManagedReference

    private List<Consultation> consultations = new ArrayList<>();

    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    @NotBlank(message = "O nome do animal é obrigatório")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "A espécie do animal é obrigatória")
    @Column(name = "species", nullable = false)
    private String species;

    @NotBlank(message = "A raça do animal é obrigatória")
    @Column(name = "race", nullable = false)
    private String race;

    @NotNull(message = "A idade do animal é obrigatória")
    @Column(name = "age", nullable = false)
    private Integer age;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;

    }

    public MedicalRecord getMedicalRecord(){ return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord){
        this.medicalRecord = medicalRecord;
        if (medicalRecord != null){
            medicalRecord.setAnimal(this);
        }
    }
}
