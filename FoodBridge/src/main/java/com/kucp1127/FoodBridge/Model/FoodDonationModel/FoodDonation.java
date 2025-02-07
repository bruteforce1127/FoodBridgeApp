package com.kucp1127.FoodBridge.Model.FoodDonationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private List<String> foodItems;

    @ElementCollection
    private List<Integer> foodQuantity;

    @ElementCollection
    @Temporal(TemporalType.DATE) // Stores only the date part
    private List<Date> expiryDate;

    private String address;
    private String donorName;
    private String donorContact;

    @Temporal(TemporalType.TIMESTAMP) // Stores date + time
    private Date donationDate;

    private String donationStatus;
    private String donationType;
    private String additionalNotes;
    private String imageUrl;

    @Version
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private Integer version;
}
