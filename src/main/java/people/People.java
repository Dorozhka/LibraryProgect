
package people;

import java.util.ArrayList;
import Library.Book;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public abstract class People {
    private String name;
    private boolean sex; //true - female; false - male
    private ArrayList<Book> takenBooks;
    public People(String name, boolean sex, ArrayList<Book> takenBooks){
        this.name = name;
        this.sex = sex;
        if(takenBooks == null) {
            this.takenBooks = new ArrayList<>();
        }
        else {
            this.takenBooks = takenBooks;
        }
    }
    public String getName() {
        return name;
    }
    public boolean getSex() {
        return sex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public ArrayList<Book> getTakenBooks() {
        return takenBooks;
    }
    public void setBooks(ArrayList<Book> takenBooks) {
        ArrayList<Book> books = new ArrayList<>(takenBooks);
        this.takenBooks = books;
    } 
    public void takeBook(ArrayList<Book> books){
        int randomOfQuantity;
        int random;
        ArrayList<Book> copybooks = new ArrayList<>(books);
        randomOfQuantity = (int)Math.round(Math.random()*7+3);
        for(int j = 0; j < randomOfQuantity; j++){
            random = (int)Math.round(Math.random()*(copybooks.size()-1));
            takenBooks.add(copybooks.get(random));
            copybooks.remove(random);
        }
    }
    public MutableTreeNode getBookNode(){
        DefaultMutableTreeNode bookNode = new DefaultMutableTreeNode(this.getName());
        for (Book book: takenBooks){
            bookNode.add(new DefaultMutableTreeNode(book.getName()));
        }
        return bookNode;
    }
}


