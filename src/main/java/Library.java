

public class Library {
    public static void main(String[] args){
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Button().setVisible(true);
            }
        });
        
    }
}