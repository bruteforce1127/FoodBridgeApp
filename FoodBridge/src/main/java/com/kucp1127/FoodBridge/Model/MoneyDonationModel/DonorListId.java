package com.kucp1127.FoodBridge.Model.MoneyDonationModel;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorListId implements Serializable {
    private int donationId;
    private String donorName;
}
