
public class Students implements Comparable<Students>{
    
    private int id;
    private Name name;
    private String major;
    private Double gpa;
    private int creditHours;

    public Students(int id, Name name, String major , Double gpa, int creditHours) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.creditHours = creditHours;
        this.major = major;
    }
    
    public Students(){
    this(0 ,null ,null,  0.0, 0);
    }
    
    public Students(Students other){
        this(other.getId() , other.getName() ,other.getMajor(), other.getGpa() , other.getCreditHours());
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    
    @Override
    public boolean equals(Object other){
        if(other == null)
            throw new NullPointerException("No Students Object to equals with.");
        
        if(other.getClass().getName().equals("ProjectCS102.Students")){
            
            Students ref = (Students)other;
            
            return (this.id == ref.getId());
        }else throw new ClassCastException("Object must be of type Studetns");
       
    }

    @Override
    public int compareTo(Students other) {
        if(other == null)
            throw new NullPointerException("No Students Object To Compare with. ");
        
        return (this.id - other.getId());
    }

    @Override
    public String toString() {
   return String.format("%-10d%-35s%-20s%-15.3f%-4d\n" , getId(), getName(), getMajor(), getGpa(), getCreditHours());
        
    }
    

       
                
    
    
                                            
    
      
}
