package com.llibreria.munozkarolayn.llibre.Service;

import com.llibreria.munozkarolayn.llibre.Model.Llibre;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface  LlibreService {
    Llibre save(Llibre llibre);
    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    Optional<Llibre> findByIdLlibre(Integer id);
    boolean validacioISBN(String isbn);
    boolean validarCredencials(String usuari, String password);
    Optional<LocalDate> parseData(String dataString);
}
