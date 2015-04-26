package rouen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "cv")
public class Cv {

	String name;
	String prenom;
	String adresse;
    int age;
    int telephone;
    int id;
    ArrayList<Competance> competances;
    ArrayList<Formation> formations;
    ArrayList<Langue> langues;
    ArrayList<Experience_pro> experiences;
    

    public Cv() {
		super();
		competances= new ArrayList<Competance>();
		formations= new ArrayList<Formation>();
		langues= new ArrayList<Langue>();
		experiences= new ArrayList<Experience_pro>();
	}

	
	


	

	public Cv(String name, String prenom, String adresse, int age,
			int telephone, int id, ArrayList<Competance> competances,
			ArrayList<Formation> formations, ArrayList<Langue> langues,
			ArrayList<Experience_pro> experiences) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.adresse = adresse;
		this.age = age;
		this.telephone = telephone;
		this.id = id;
		this.competances = competances;
		this.formations = formations;
		this.langues = langues;
		this.experiences = experiences;
	}







	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	
	public int getAge() {
		return age;
	}
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}
	@XmlElement
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	


	public String getAdresse() {
		return adresse;
	}
	
	@XmlElement
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return telephone;
	}
	@XmlElement
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}







	public ArrayList<Competance> getCompetances() {
		return competances;
	}






	@XmlElement
	public void setCompetances(ArrayList<Competance> competances) {
		this.competances = competances;
	}







	public ArrayList<Formation> getFormations() {
		return formations;
	}






	@XmlElement
	public void setFormations(ArrayList<Formation> formations) {
		this.formations = formations;
	}







	public ArrayList<Langue> getLangues() {
		return langues;
	}






	@XmlElement
	public void setLangues(ArrayList<Langue> langues) {
		this.langues = langues;
	}







	public ArrayList<Experience_pro> getExperiences() {
		return experiences;
	}






	@XmlElement
	public void setExperiences(ArrayList<Experience_pro> experiences) {
		this.experiences = experiences;
	}
	
	
		
	}
	
		
