package com.nebulosa.clinica_estelar.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table (name = "consultation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "consultation_id")
    private Long id;

    @NotNull(message = "A data e hora da consulta são obrigatórias")
    @Column (name = "data_time", nullable = false)
    private LocalDate dataTime;

    @NotBlank(message = "A descrição da consulta é obrigatória")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonBackReference

    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", nullable = false)
    @JsonBackReference

    private Veterinarian veterinarian;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDate dataTime) {
        this.dataTime = dataTime;
    }
}
