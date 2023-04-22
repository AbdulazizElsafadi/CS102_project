
import java.util.Comparator;


public class ComparatorBasedOnLastName implements Comparator<Name>{
    
     @Override
    public int compare(Name other1, Name other2) {
        if(other1 == null || other2 == null)
            throw new NullPointerException("there is no Object to compare with (Name Object must be LastName). ");
        
        return(other1.getLastName()).compareTo(other2.getLastName());
    }
    
}
