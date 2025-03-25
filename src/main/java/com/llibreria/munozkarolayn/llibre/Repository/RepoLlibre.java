package com.llibreria.munozkarolayn.llibre.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.llibreria.munozkarolayn.llibre.Model.Llibre;

@Repository
public class RepoLlibre {

    ArrayList<Llibre> llibres = new ArrayList<Llibre>();

    public RepoLlibre() {
        llibres.add(new Llibre(1,"HARRY POTTER I EL PRESONER D'AZKABAN","JK Rowling","Salamandra","26/9/2006","fantastica"));
        llibres.add(new Llibre(2,"CODI DA VINCI","Dan Brown","Ariel","26/9/2006","ficcio"));
    }

    public ArrayList<Llibre> getAllLlibres() {
        return llibres;
    }

    public void InsertaLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre getLlibreID(int id) {
        Llibre llibre = null;
        for (Llibre l1:llibres) {  //Opció clàssica, imperativa
            if (l1.getIdLlibre() == id) {
                llibre = l1;
            }
        }
        return llibre;
    }
}