package rouen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("/Resume")
public class XMLController {
	private ListCv cvs;
	//Cv cv;
	XMLController(){
		ArrayList<Competance> competances = new ArrayList<Competance>();
	    ArrayList<Formation> formations = new ArrayList<Formation>();
	    ArrayList<Langue> langues = new ArrayList<Langue>();
	    ArrayList<Experience_pro> experiences = new ArrayList<Experience_pro>();

	    competances.add(new Competance("developpeur java", "developpement des applications java  "));
	    competances.add(new Competance("designeur web", "design"));
	    formations.add(new Formation("2015", "master2"));
	    formations.add(new Formation("2014", "license"));
	    langues.add(new Langue("français", 1));
	    langues.add(new Langue("anglais", 1));
	    experiences.add(new Experience_pro("3 ans ", "developpement des application android"));
	    experiences.add(new Experience_pro("2 ans ", "architecture logiciel "));

	    Cv cv = new Cv("Luc", "maxime", " rouen 76000", 25, 0123456, 1, competances, formations, langues, experiences);
	    Cv cv2 = new Cv("Ben Nasr", "Amir", "Mont saint aignan", 20, 0123456, 2, competances, formations, langues, experiences);

        cvs = new ListCv();
	    cvs.addCv(cv);
	    cvs.addCv(cv2);
	}
	 
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Cv getCvsInXML(@PathVariable String id) {
		int idInt = Integer.valueOf(id);
		return cvs.findCv(idInt);
		//return cv;
	}
	
	
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody ListCv getCvInXML() {
		return cvs;
		//return cv;
		
	}

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void putCvsInXML(@RequestBody Cv cv) {
        cvs.addCv(cv);
    }

	
}