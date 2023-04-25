package Library;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class RussianBookFactory implements Bookfactory{

    @Override
    public Book createTextbook() {
        String name = null;
        String type = null;
        String fullName = null;
        try {
            type = this.excelprovider.randomOfName("Русские учебники", 0);
            fullName = this.excelprovider.randomOfName("Русские учебники", 1);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(RussianBookFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = type + " по " + fullName;
        return new RussianTextbook(name);
    }

    @Override
    public Book createFiction(int numCol) {
        String name = null;
        String first = null;
        String second = null;
        String third = null;
        try {
            first = this.excelprovider.randomOfName("Русская литература", numCol);
            second = this.excelprovider.randomOfName("Русская литература", (numCol+1));
            third = this.excelprovider.randomOfName("Русская литература", (numCol+2));
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(RussianBookFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = first + " " + second + " " + third;
        return new RussianFiction(name);
    }
}
