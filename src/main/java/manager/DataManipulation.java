
package manager;

import Library.Book;
import Library.EnglishBookFactory;
import Library.RussianBookFactory;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import people.Student;
import people.StudentFactory;
import people.Teacher;
import people.TeacherFactory;

public class DataManipulation {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    public void creationStudent(){
        StudentFactory studentfactory = new StudentFactory();
        for(int i = 0; i<61; i++){
            students.add((Student) studentfactory.createPerson(studentfactory.sexGetting()));
            students.get(i).takeBook(books);
        }
    }
    public void creationTeacher(){
        TeacherFactory teacherfactory = new TeacherFactory();
        for(int i = 0; i<21; i++){
            teachers.add((Teacher) teacherfactory.createPerson(teacherfactory.sexGetting()));
            teachers.get(i).takeBook(books);
        }
    }
    public void creationBook(){
        EnglishBookFactory ebfactory = new EnglishBookFactory();
        RussianBookFactory rbfactory = new RussianBookFactory();
        int randomRussianFiction;
        int randomRussianTextbook;
        int randomFiction;
        randomRussianFiction = (int)Math.round(Math.random()*15+20);
        randomRussianTextbook = (int)Math.round(Math.random()*15+20);
        for(int i = 0; i<randomRussianFiction; i++){
            randomFiction = ((int)Math.round(Math.random()*2))*3;
            books.add(rbfactory.createFiction(randomFiction));
        }
        for(int i = 0; i<50-randomRussianFiction; i++){
            books.add(ebfactory.createFiction(0));
        }
        for(int i = 0; i<randomRussianTextbook; i++){
            books.add(rbfactory.createTextbook());
        }
        for(int i = 0; i<50-randomRussianTextbook; i++){
            books.add(ebfactory.createTextbook());
        }
    }

    public TreeNode addInfoToGUI() {
       DefaultMutableTreeNode main = new DefaultMutableTreeNode("Пользователи");
       main.add(getStudentNodes());
       main.add(getTeacherNodes());
       return main;
    }

    private MutableTreeNode getStudentNodes() {
        DefaultMutableTreeNode stNode = new DefaultMutableTreeNode("Студенты");
        for (Student student: students){
            stNode.add(student.getBookNode());
        }
        return stNode;
    }

    private MutableTreeNode getTeacherNodes() {
        DefaultMutableTreeNode tchNode = new DefaultMutableTreeNode("Преподаватели");
        for (Teacher teacher: teachers){
            tchNode.add(teacher.getBookNode());
        }
        return tchNode;
    }
    
}

