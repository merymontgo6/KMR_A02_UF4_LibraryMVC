package com.llibreria.munozkarolayn.llibre.Model;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llibre")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLlibre;
    @Column(nullable = false)
    private String titol;
    @Column
    private String autor;
    @Column
    private String editorial;
    @Column(name = "data_publicacio")
    private LocalDate dataPublicacio;
    @Column
    private String tematica;
    @Column(unique = true, nullable = false)
    private String isbn;   
}
