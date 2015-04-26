package rouen;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Langue")
public class Langue {
private String language;
private int niveau;

public Langue(){
	super();
}
public Langue(String language, int niveau){
	this.language=language;
	this.niveau=niveau;
}
public String getLanguage() {
	return language;
}
@XmlElement
public void setLanguage(String language) {
	this.language = language;
}
public int getNiveau() {
	return niveau;
}
@XmlElement
public void setNiveau(int niveau) {
	this.niveau = niveau;
}
}
