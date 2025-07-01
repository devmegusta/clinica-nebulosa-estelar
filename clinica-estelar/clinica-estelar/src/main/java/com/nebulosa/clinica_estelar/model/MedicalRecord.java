package com.nebulosa.clinica_estelar.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medical_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "medical_record_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "animal_id", nullable = false, unique = true)
    @JsonBackReference
    private Animal animal;

    @NotBlank(message = "O histórico clínico não pode estar vazio")
    @Column(name = "history", nullable = false, columnDefinition = "TEXT")
    private String history;

    @Column(name = "alergias", columnDefinition = "TEXT")
    private String alergias;

    @Column(name = "vacinas", columnDefinition = "TEXT")
    private String vacinas;

    @Column(name = "tratamentos", columnDefinition = "TEXT")
    private String tratamentos;

    @Column(name = "cirurgias", columnDefinition = "TEXT")
    private String cirurgias;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getTratamentos() {
        return tratamentos;
    }

    public void setTratamentos(String tratamentos) {
        this.tratamentos = tratamentos;
    }

    public String getVacinas() {
        return vacinas;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
