package com.kucp1127.FoodBridge.Repository.MoneyDonationRepository;

import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonorList;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonorListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DonorListRepository extends JpaRepository<DonorList , DonorListId> {
    public List<DonorList> findByIdDonorName(String donorName);

    public List<DonorList> findByIdDonationId(int donationId);




}
