package controller;

import service.BibliotecaService;
import domain.*;

public class BibliotecaController {
    private BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService service) {
        this.bibliotecaService = service;
    }

    public void adaugaCarte(Carte carte) {
        bibliotecaService.adaugaCarte(carte);
    }

    public void imprumutaCarte(Carte carte, Cititor cititor) {
        bibliotecaService.imprumutaCarte(carte, cititor);
    }

}
