import java.io.Serializable;
public abstract class Person implements Serializable{
    private int id;
    private String name;
    private String contact;

    public Person(int id, String name, String contact){
        this.id = id;
        this.name=name;
        this.contact=contact;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getContact(){
        return contact;
    }
}
