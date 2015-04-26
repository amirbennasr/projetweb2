
package Controleur;

import Model.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by user on 24/04/2015.
 */
public class MyClient {
    private static Object ex;



    public static ListCv listecv() throws IOException, JAXBException {


        URL url = new URL("http://localhost:8080/ProjetXml/rest/Resume");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String apiOutput = br.readLine();
        System.out.println(apiOutput);
        conn.disconnect();

        JAXBContext jaxbContext = JAXBContext.newInstance(ListCv.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListCv listeDeCV = (ListCv) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));

        System.out.println(listeDeCV.getCvs().get(0).getName());


        System.out.println("Done");
        return listeDeCV;

    }

    public static void SendXmlToServerWithPost(Cv nouveauCv)  throws IOException, JAXBException{

        URL url = new URL("http://projetweb2.herokuapp.com/rest/Resume");

        JAXBContext jaxbContext = JAXBContext.newInstance(Cv.class,ListCv.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Client client = Client.create();
        WebResource webResource = client.resource("https://projetweb2.herokuapp.com/rest/Resume");
        ClientResponse send = webResource.accept("application/xml").post(ClientResponse.class , nouveauCv);
        jaxbMarshaller.marshal(nouveauCv, System.out);
        //*/


    }


    public static void main(String[] args) throws IOException, JAXBException {
         ListCv cvs;

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



        // SendXmlToServerWithPost(cv);
        System.out.println("Done");


    }




}
