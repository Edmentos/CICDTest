package ie.atu.cicd_test;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class RentalService {
    private List<rental> myList = new ArrayList<>();
    public List<rental> addRental(rental rental)
    {
        myList.add(rental);
        return myList;
    }
    public List<rental> putRental(rental rental){
        for(int i = 0; i<myList; i++) {
             if (myList.get(i).equals(Id)) {
                 myList.set(i, rental);
          }
        }
        return myList;
    }

    public List<rental> deleteRental(String Id){
        for(int count=0;count<myList.size();count++){
            if(myList.get(count).equals(Id)){
                myList.remove(count);
            }
        }
        return myList;
    }

    public List<rental> getRental(String Id){
        for(int number=0;number<myList.size();number++){
            if(myList.get(number).equals(Id)){
                myList.get(number);
            }
        }
        return myList;
    }


}
