package com.llibreria.munozkarolayn.llibre.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.llibreria.munozkarolayn.llibre.Model.Llibre;
import com.llibreria.munozkarolayn.llibre.Model.Usuaris;
import com.llibreria.munozkarolayn.llibre.Repository.RepoLlibre;
import com.llibreria.munozkarolayn.llibre.Service.LlibreService;

@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    private LlibreService llibreService;
    @Autowired
    private RepoLlibre repoLlibre;

    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }
    
    @PostMapping("/index")
    public String login(@RequestParam String usuari, 
                       @RequestParam String password) {
        if (llibreService.validarCredencials(usuari, password)) {
            return "index";
        } else {
            return "login";
        }        
    }

    @GetMapping("/index")
    public String index(@ModelAttribute("users") Usuaris users, Model model) {
            return "index";
    }

    @GetMapping("/inserir")
    public String mostrarFormInserir(@ModelAttribute("users") Usuaris users, Model model) {
        model.addAttribute("llibreErr", false);
        model.addAttribute("message", "");
        return "inserir";
    }

    @GetMapping("/consulta") 
    public String consulta(@ModelAttribute("users") Usuaris users, Model model) {
        model.addAttribute("llibres", llibreService.findAll());
        return "consulta";
    }
    
    @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {
        Llibre llibre = new Llibre();
        llibre.setIdLlibre(0);
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        model.addAttribute("llibre", llibre);
        return "cercaid";
    }

    @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
        
        String message = "";
        boolean llibreErr = false;

        try {
            int idLlib = Integer.parseInt(idLlibre);
            Optional<Llibre> llibre = llibreService.findByIdLlibre(idLlib);
            if(llibre.isPresent()) {
                model.addAttribute("llibre", llibre.get());
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }

        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);
        return "cercaid";
    }

    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }

    @ModelAttribute("users")
    public Usuaris getDefaultUser() {
        return new Usuaris(); 
    }

    @PostMapping("/inserir")
    public String inserir(@RequestParam(name = "titol") String titol,
                         @RequestParam(name = "autor") String autor,
                         @RequestParam(name = "editorial") String editorial,
                         @RequestParam(name = "datapublicacio") String datapublicacio,
                         @RequestParam(name = "tematica") String tematica,
                         @RequestParam(name = "isbn") String isbn,
                         Model model) {
        
        try {
            if (!llibreService.validacioISBN(isbn)) {
                model.addAttribute("message", "ISBN invàlid");
                model.addAttribute("llibreErr", true);
                return "inserir";
            }
    
            Optional<LocalDate> data = llibreService.parseData(datapublicacio);
            if (data.isEmpty()) {
                model.addAttribute("message", "Format de data invàlid (DD/MM/YYYY)");
                model.addAttribute("llibreErr", true);
                return "inserir";
            }
    
            Llibre llibre = new Llibre();
            llibre.setTitol(titol.trim());
            llibre.setAutor(autor.trim());
            llibre.setEditorial(editorial.trim());
            llibre.setDataPublicacio(data.get());
            llibre.setTematica(tematica.trim());
            llibre.setIsbn(isbn.trim());
    
            Llibre saved = llibreService.save(llibre);
            
            if (saved != null) {
                model.addAttribute("message", "Llibre inserit correctament");
                model.addAttribute("llibreErr", false);
                model.addAttribute("llibres", llibreService.findAll());
                return "consulta";
            } else {
                throw new RuntimeException("Error al guardar el llibre");
            }
    
        } catch (Exception e) {
            model.addAttribute("message", "Error al inserir el llibre: " + e.getMessage());
            model.addAttribute("llibreErr", true);
            return "inserir";
        }
    }
}