
package people;

import Library.Book;
import java.util.ArrayList;

public class Student extends People{
    
    public Student(String name, boolean sex, ArrayList<Book> takenBooks) {
        super(name, sex, takenBooks);
    }
    
}
