package rouen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;

/**
 * Created by USER on 24/04/2015.
 */
@XmlRootElement(name = "Cvs")
public class ListCv {
    private LinkedList<Cv> cvs;

    public ListCv(LinkedList<Cv> cvs) {
        this.cvs = cvs;
    }

    public ListCv() {
        cvs = new LinkedList<Cv>();
    }

    public LinkedList<Cv> getCvs() {
        return cvs;
    }

    @XmlElement
    public void setCvs(LinkedList<Cv> cvs) {
        this.cvs = cvs;
    }

    public void addCv(Cv cv){
        cvs.add(cv);
    }


    public Cv findCv(int i){
        if(i<=cvs.size() && i>0)
            return cvs.get(i-1);
        return null;
    }
}
