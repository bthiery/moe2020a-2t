public class Alerte {

    private String type;
    private String contenu;
    private Boolean actif;

    public Alerte() {

    }

    public Alerte(String type, String contenu) {
        this.type = type;
        this.contenu = contenu;
        this.actif = true;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean estActif() {
        return true;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getContenu() {
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
