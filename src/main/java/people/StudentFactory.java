package people;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class StudentFactory extends PeopleFactory {

    @Override
    public People createPerson(boolean sex) {
        String name = null;
        String nameOfSheet = "Студентки";
        if(!sex){
            nameOfSheet = "Студенты";
        }
        String firstName = null;
        String secondName = null;
        try {
            firstName = this.excelprovider.randomOfName(nameOfSheet, 0);
            secondName = this.excelprovider.randomOfName(nameOfSheet, 1);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(StudentFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = firstName + " " + secondName;
        return new Student(name, sex, new ArrayList<>());
    }
    @Override
    public boolean sexGetting() {
        boolean sex = true;
        double random = Math.random();
        if (random > 0.55){
            sex = false;
        }
        return sex;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
