package Library;

public class EnglishTextbook extends Book{
    private String level;
    public EnglishTextbook(String name, String level){
        super(name);
        this.level = level;
    }  
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }    
}
