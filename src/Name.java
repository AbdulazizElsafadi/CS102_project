
public class Name implements Comparable<Name>{
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String major;
    private String age;
    private String email;

    public Name(String firstName, String middleName, String lastName, String major, String age, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName; 
        this.age = age;
        this.major = major;
        this.email = email;
    }
    
    public Name(){
        this(null , null , null, null, null, null);
    }
    
    public Name(Name other){
        this(other.getFirstName() , other.getMiddleName() , other.getLastName(),other.getMajor() ,other.getAge(), other.getEmail());
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFristName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
    
    @Override
    public boolean equals(Object other){
      if(other == null)
            throw new NullPointerException("There is no Name object to equals with. ");  
      
      if(other.getClass().getName().equals("ProjectCS102.Name")){
          
          Name ref = (Name)other;
 return (this.firstName.equalsIgnoreCase(ref.getFirstName())& this.middleName.equalsIgnoreCase(ref.getMiddleName())
         & this.lastName.equalsIgnoreCase(ref.getLastName()));
          
      }else throw new ClassCastException("Object must be of type Name");
     }

    @Override
    public int compareTo(Name other) {
        if(other == null)
            throw new NullPointerException("There is no Name object to compare with. ");
        
        return (this.firstName.compareTo(other.getFirstName()) & this.middleName.compareTo(other.getMiddleName())
              &  this.lastName.compareTo(other.getLastName()));
    }
    
    
    @Override
    public String toString(){
        return String.format(" %s %s %s", getFirstName() , getMiddleName() , getLastName());
    }
    
   
    
} 
