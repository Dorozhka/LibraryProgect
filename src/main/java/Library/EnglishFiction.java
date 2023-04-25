package Library;

public class EnglishFiction extends Book{
    private String year;
    public EnglishFiction(String name, String year){
        super(name);
        this.year = year;
    } 
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}
