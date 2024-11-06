package ie.atu.cicd_test;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
@RestController
public class RentalController {
    private RentalService myrental;

    public RentalController(RentalService myrental){
        this.myrental=myrental;
    }
    private List<rental> myList = new ArrayList<>();

    @PostMapping("/rentals")
    public List<rental>addRental(@Valid @RequestBody rental rental)
    {
        return myrental.addRental(rental);
    }
    @GetMapping("/rentals/{rentalCode}")
    public List<rental>getRental(@PathVariable String rentalCode) //Might have to change to requestparam...
    {
        return myrental.getRental(rentalCode);
    }

    @PutMapping("/rentals/{rentalCode}")
    public List<rental>putRental(@PathVariable String rentalCode, @RequestBody rental rental)
    {
        return myrental.putRental(rental);
    }

    @DeleteMapping("/rentals/{rentalCode}")
    public List<rental>deleteRental(PathVariable String rentalCode)
    {
        return myrental.deleteRental(rentalCode);
    }
}

