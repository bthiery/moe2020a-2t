package com.hellokoding.ihm;

// cette classe est la représentation de toute ligne de tableau affichant des personnes
// on utilise donc cet objet graphique pour afficher une liste de Alertes

public class AlerteLine {

    private String typeCell;
    private String contenuCell;
    private String actifCell;

    public AlerteLine() {

    }

    public AlerteLine(String type, String contenu, Boolean actif) {
        this.typeCell = type;
        this.contenuCell = contenu;
        this.actifCell = actif;
    }

	// attention : avec getfirstNameCell => Exception evaluating SpringEL expression: "PersonLine.firstNameCell"
    public String getTypeCell() {
        return typeCell;
    }

    public void setTypeCell(String type) {
        this.typeCell = type;
    }

    public String getContenuCell() {
        return contenuCell;
    }

    public void setContenuCell(String contenu) {
        this.contenuCell = contenu;
    }

    public Boolean getActifCell() {
        return actifCell;
    }

    public void setActifCell(Boolean actif) {
      this.actifCell = actif;
    }

}
