package ec.edu.espe.inclass.controller;

import com.google.gson.Gson;
import ec.edu.espe.inclass.model.Tutorship;
import java.util.ArrayList;

/**
 *
 * @author Stephen Drouet, Developer Bears, DCC-ESPE
 */
public class TutorshipController {

    public static ArrayList loadTutorships(ArrayList<String> jsons) {
        ArrayList<Tutorship> tutorships;
        tutorships = new ArrayList<>();

        for (String json : jsons) {
            tutorships.add(jsonToTutorship(json));
        }

        return tutorships;
    }

    public static Tutorship jsonToTutorship(String json) {
        Tutorship tutorship;
        Gson gson;
        gson = new Gson();
        tutorship = new Tutorship();
        
        tutorship = gson.fromJson(json, tutorship.getClass());

        return tutorship;
    }
}
