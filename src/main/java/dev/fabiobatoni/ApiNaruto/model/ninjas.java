package dev.fabiobatoni.ApiNaruto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ninjas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ninjas {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String aldeia;
    int idade;
    String elemento;
    String imgUrl;
}
