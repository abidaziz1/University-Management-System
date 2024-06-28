public class Professor extends Person{
    private String speciality;

    public Professor(int id, String name, String contact, String speciality){
        super(id, name, contact);
        this.speciality=speciality;
    }

    public String getSpeciality(){
        return speciality;
    }

    @Override
    public String toString(){
        return "Professor{"+"speciality='"+speciality+'\''+", Id="+getId()+", name='"+getName()+'\''+", contact='"+getContact()+'}';
    }
}
