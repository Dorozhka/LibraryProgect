
package people;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TeacherFactory extends PeopleFactory {

    @Override
    public People createPerson(boolean sex) {
        String name = null;
        String nameOfSheet = "Преподаватели";
        if(sex){
            nameOfSheet = "Преподавательницы";
        }
        String firstName = null;
        String secondName = null;
        String thirdName = null;
        try {
            firstName = this.excelprovider.randomOfName(nameOfSheet, 0);
            secondName = this.excelprovider.randomOfName(nameOfSheet, 1);
            thirdName = this.excelprovider.randomOfName("Отчества", 0);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(TeacherFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(sex){
            name = secondName + " " + firstName + " " + thirdName + "на";
        }else{
            name = secondName + " " + firstName + " " + thirdName + "ич";
        }
        return new Teacher(name, sex,  new ArrayList<>());
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean sexGetting() {
        boolean sex = false;
        double random = Math.random();
        if (random > 0.6){
            sex = true;
        }
        return sex;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
