
package Library;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class EnglishBookFactory implements Bookfactory{

    @Override
    public Book createTextbook() {
        String name = null;
        String level = null;
        String fullName = null;
        String author = null;
        String university = null;
        try {
            level = this.excelprovider.randomOfName("Английские учебники", 0);
            fullName = this.excelprovider.randomOfName("Английские учебники", 1);
            author = this.excelprovider.randomOfName("Английские учебники", 3);
            university = this.excelprovider.randomOfName("Английские учебники", 2);
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(EnglishBookFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = level + ": " +university + " " + fullName + " by " + author;
        return new EnglishTextbook(name, level);
    }

    @Override
    public Book createFiction(int numCol) {
        String name = null;
        String fullName = null;
        String author = null;
        String year = null;
        try {
            fullName = this.excelprovider.randomOfName("Английская литература", numCol);
            author = this.excelprovider.randomOfName("Английская литература", (numCol+1));
            year = this.excelprovider.randomOfName("Английская литература", (numCol+2));
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(EnglishBookFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = fullName + " by " + author + " in " + year;
        return new EnglishFiction(name, year);
    }
}
