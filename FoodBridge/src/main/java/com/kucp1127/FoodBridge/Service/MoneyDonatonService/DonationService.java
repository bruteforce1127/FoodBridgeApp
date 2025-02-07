package com.kucp1127.FoodBridge.Service.MoneyDonatonService;

import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequest;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequestDTO;
import com.kucp1127.FoodBridge.Repository.MoneyDonationRepository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService {


    @Autowired
    private DonationRequestRepository donationRequestRepository;


    @Autowired
    private DonorService donorService;

    @Autowired
    private DonationRequestDTO donationRequestDTO;

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

    public Optional<DonationRequest> updateDonation(DonationRequest donationData, int id) {
        Optional<DonationRequest> donationRequest = donationRequestRepository.findById(id);
        if(donationRequest.isPresent()){
            donationRequest.get().setCollectedAmount(donationData.getCollectedAmount());
            donationRequest.get().setCategory(donationData.getCategory());
            donationRequest.get().setCity(donationData.getCity());
            donationRequest.get().setCompleted(donationData.isCompleted());
            donationRequest.get().setDescription(donationData.getDescription());
            donationRequest.get().setRequiredAmount(donationData.getRequiredAmount());
            donationRequest.get().setDonationName(donationData.getDonationName());
            donationRequest.get().setEndDate(donationData.getEndDate());
            donationRequest.get().setImageUrl(donationData.getImageUrl());
            donationRequest.get().setStartDate(donationData.getStartDate());
            donationRequest.get().setCountry(donationData.getCountry());
            donationRequest.get().setPaymentMethod(donationData.getPaymentMethod());
        }
        return Optional.of(donationRequestRepository.save(donationRequest.get()));
    }


//    @Transactional
//    public Optional<DonationRequest> addDonation(DonationRequestDTO donationRequestDTO) {
//        int id = donationRequestDTO.getId();
//        long amount = donationRequestDTO.getAmount();
//        try {
//            return donationRequestRepository.findById(id).map(donationRequest -> {
//
//
//                // Update collected amount safely
//                donationRequest.setCollectedAmount(donationRequest.getCollectedAmount() + amount);
//
//
//                donorService.updateDonation(donationRequestDTO);
//
//
//                // Save the updated record
//                return Optional.of(donationRequestRepository.save(donationRequest));
//            }).orElse(Optional.empty());
//        } catch (ObjectOptimisticLockingFailureException e) {
//            throw new RuntimeException("Concurrent update detected. Please try again.");
//        }
//    }
}
