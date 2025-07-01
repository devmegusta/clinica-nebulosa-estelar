package com.nebulosa.clinica_estelar.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "veterinarians")
public class Veterinarian {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "veterinarian_id")
    private Long id;

    @NotBlank (message = "Nome do veterinário é obrigatório!")
    @Column (name = "veterrinarian_name", nullable = false)
    private String name;

    @Email (message = "email inválido!")
    @NotBlank (message = "Email do veterinário é obrigatório!")
    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank (message = "O CRMV é obrigatório")
    @Column (name = "crmv", nullable = false, unique = true)
    private String crmv;

    @NotBlank (message = "Especialidade é obrigatória!")
    private String specialty;

    @OneToMany (mappedBy = "veterinarian")
    @JsonManagedReference

    private List<Consultation> consultations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
