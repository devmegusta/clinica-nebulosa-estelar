package com.nebulosa.clinica_estelar.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "tutor_id")
    private Long id;

    @NotBlank (message = "Nome obrigatório!")
    @Column (name = "tutor_name")
    private String name;

    @Pattern(
            regexp = "^\\d{10,11}$",
            message = "Telefone inválido"
    )
    @NotBlank(message = "Telefone é obrigatório!")
    @Column(name = "phone_number")
    private String phoneNumber;


    @NotBlank (message = "Endereço é obrigatório!")
    @Column (name = "adress")
    private String adress;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference

    private List<Animal> animals = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Animal> getAnimais() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
