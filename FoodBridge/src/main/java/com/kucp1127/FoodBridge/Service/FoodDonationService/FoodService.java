package com.kucp1127.FoodBridge.Service.FoodDonationService;

import com.kucp1127.FoodBridge.Model.FoodDonationModel.FoodDonation;
import com.kucp1127.FoodBridge.Repository.FoodDonationRepository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodDonationRepository;

    public Optional<List<FoodDonation>> getAllFoodDonation(){
        return Optional.of(foodDonationRepository.findAll());
    }

    public Boolean deleteADonation(int id){
        if(foodDonationRepository.existsById(id)) foodDonationRepository.deleteById(id);
        return foodDonationRepository.existsById(id);
    }

    public Optional<FoodDonation> getFoodDonationById(int id) {
        return foodDonationRepository.findById(id);
    }

    public Optional<FoodDonation> postFoodDonation(FoodDonation foodDonation) {
        return Optional.of(foodDonationRepository.save(foodDonation));
    }

    public Optional<FoodDonation> upDateFoodDonation(FoodDonation foodDonation, int id) {
        Optional<FoodDonation> foodDonation1 = foodDonationRepository.findById(id);
        if (foodDonation1.isPresent()) {
            FoodDonation existing = foodDonation1.get();
            existing.setFoodItems(foodDonation.getFoodItems());
            existing.setFoodQuantity(foodDonation.getFoodQuantity());
            existing.setExpiryDate(foodDonation.getExpiryDate());
            existing.setAddress(foodDonation.getAddress());
            existing.setDonorName(foodDonation.getDonorName());
            existing.setDonorContact(foodDonation.getDonorContact());
            existing.setDonationDate(foodDonation.getDonationDate());
            existing.setDonationStatus(foodDonation.getDonationStatus());
            existing.setDonationType(foodDonation.getDonationType());
            existing.setAdditionalNotes(foodDonation.getAdditionalNotes());
            existing.setImageUrl(foodDonation.getImageUrl());
            return Optional.of(foodDonationRepository.save(existing));
        }
        return Optional.empty();
    }
}