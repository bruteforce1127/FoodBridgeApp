package com.kucp1127.FoodBridge.Model.MoneyDonationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRequestDTO {
    private int donationId;
    private String donorName;
    private int donationAmount;
    private String transactionId;
}


/* This is a class I have created specifically for adding donor name to the donor list of the
DonationRequest class if the id matches with the id of the particular element of the
DonationRequest it adds it to the particular entity of the class
*/
