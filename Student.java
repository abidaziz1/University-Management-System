
public class Student extends Person{
    public Student(int id, String name, String contact){
        super(id, name, contact);
    } 

    @Override
    public String toString(){
        return "Student{"+", Id="+getId()+", name='"+getName()+'\''+", contact='"+getContact()+'}';
    }

}
