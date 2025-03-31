package com.llibreria.munozkarolayn.llibre.Repository;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.llibreria.munozkarolayn.llibre.Model.Llibre;

@Repository
public class RepoLlibre {
    ArrayList<Llibre> llibres = new ArrayList<Llibre>();
    public ArrayList<Llibre> getAllLlibres() {
        return llibres;
    }
    
    public void InsertaLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre getLlibreID(int id) {
        Llibre llibre = null;
        for (Llibre l1:llibres) {
            if (l1.getIdLlibre() == id) {
                llibre = l1;
            }
        }
        return llibre;
    }
}