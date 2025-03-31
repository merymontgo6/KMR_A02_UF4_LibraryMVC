package com.llibreria.munozkarolayn.llibre.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.llibreria.munozkarolayn.llibre.Model.Llibre;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Integer> {
    
    @Override
    @NonNull
    Set<Llibre> findAll();
    Llibre findByTitol(String titol);
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    Optional<Llibre> findById(Integer id);
}