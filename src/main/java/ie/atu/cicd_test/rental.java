package ie.atu.cicd_test;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class rental {
    @Pattern(regexp ="1-9,A-Z,-",message="Must be in the format (e.g. = RENT-1234)")
    private String rentalCode;
    @Max(value=50,message = "Must be less than 50 characters long")
    private String carModel;
    @Max(value=100,message = "Must be less than 100 characters long")
    private String renterName;
    @Email(message ="Must be in the format johndoe@email.com")
    private String renterEmail;
    @Min(value=05/11/2024, message="Must be Greater than yesterdays date")
    private Date rentalStartDate;
    @Min(value=06/11/2024, message="Must be Greater than the date you got the car")
    private Date rentalEndDate;
    @DecimalMin(value= "1", message="Must be a positive value")
    private int dailyRate;

}
