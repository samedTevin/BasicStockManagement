public class Category {

    private int id;
    private String name;

    public Category(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
