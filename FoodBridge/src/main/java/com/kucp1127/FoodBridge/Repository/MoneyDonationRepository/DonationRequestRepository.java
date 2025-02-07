package com.kucp1127.FoodBridge.Repository.MoneyDonationRepository;


import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRequestRepository extends JpaRepository<DonationRequest, Integer> {

}
