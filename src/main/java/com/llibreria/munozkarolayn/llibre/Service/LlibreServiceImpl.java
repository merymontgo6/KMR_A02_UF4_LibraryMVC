package com.llibreria.munozkarolayn.llibre.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.llibreria.munozkarolayn.llibre.Model.Llibre;
import com.llibreria.munozkarolayn.llibre.Repository.LlibreRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;


@Service
public class LlibreServiceImpl implements LlibreService {

    @Autowired
    private LlibreRepository llibreRepository;

    @Override
    public boolean validarCredencials(String usuari, String password) {
        return usuari.equals("kmunoz@localhost") && password.equals("1234");
    }

    @Override
    public Set<Llibre> findAll() {
        return llibreRepository.findAll();
    }

    @Override
    public Llibre findByTitol(String titol) {
        return llibreRepository.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return llibreRepository.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(Integer id) {
        return llibreRepository.findById(id);
    }

    @Override
    public Llibre save(Llibre llibre) {
        try { 
            Llibre guardat = llibreRepository.save(llibre);
            return guardat; }
        catch (Exception e) { throw new RuntimeException("Error al guardar el llibre: " + e.getMessage()); }
    }

    @Override
    public Optional<LocalDate> parseData(String dataString) {
        try {
            return Optional.of(LocalDate.parse(dataString, 
                DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (Exception e) { return Optional.empty(); }
    }

    @Override
    public boolean validacioISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) { return false; }
        isbn = isbn.replace("-", "").replace(" ", "");
        if (isbn.length() != 10 && isbn.length() != 13) { return false; }

        for (char c : isbn.toCharArray()) {
            if (!Character.isDigit(c)) { return false; }
        }
        return true;
    }
}