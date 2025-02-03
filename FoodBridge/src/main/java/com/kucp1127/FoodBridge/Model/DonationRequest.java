package com.kucp1127.FoodBridge.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class DonationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String donationName;
    private String description;
    private long requiredAmount;
    private long collectedAmount;
    private String startDate;
    private String endDate;
    private boolean isCompleted;
    private String category;
    private String paymentMethod;
    private String city;
    private String country;
    private List<String> donors;
    private List<String> transactionIds;
}
