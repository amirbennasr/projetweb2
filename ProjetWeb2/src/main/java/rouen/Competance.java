package rouen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competance")
public class Competance {

    private String titre;
    private String description;

    public Competance() {
    }

    public Competance(String titre, String description) {
        this.titre = titre;
        this.description = description;

    }

    public String getTitre() {
        return titre;
    }
    @XmlElement
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }
}

