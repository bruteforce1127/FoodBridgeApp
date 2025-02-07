package com.kucp1127.FoodBridge.Repository.FoodDonationRepository;

import com.kucp1127.FoodBridge.Model.FoodDonationModel.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodDonation, Integer> {

}