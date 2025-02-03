package com.kucp1127.FoodBridge.Service;

import com.kucp1127.FoodBridge.Model.DonationRequest;
import com.kucp1127.FoodBridge.Repository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {


    @Autowired
    private DonationRequestRepository donationRequestRepository;

    public  Boolean deleteById(int id) {
        if(donationRequestRepository.existsById(id)){
            donationRequestRepository.deleteById(id);
        }
        return donationRequestRepository.existsById(id);
    }

    public List<DonationRequest> getDonations() {
        return donationRequestRepository.findAll();
    }

    public Optional<DonationRequest> getDonationById(int id) {
        return donationRequestRepository.findById(id);
    }

    public Optional<DonationRequest> postDonation(DonationRequest donationData) {
        return Optional.of(donationRequestRepository.save(donationData));
    }
}
