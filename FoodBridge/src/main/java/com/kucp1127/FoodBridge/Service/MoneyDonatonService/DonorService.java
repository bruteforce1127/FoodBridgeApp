package com.kucp1127.FoodBridge.Service.MoneyDonatonService;

import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequest;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequestDTO;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonorList;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonorListId;
import com.kucp1127.FoodBridge.Repository.MoneyDonationRepository.DonationRequestRepository;
import com.kucp1127.FoodBridge.Repository.MoneyDonationRepository.DonorListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DonorService {

    @Autowired
    private DonorListRepository donorListRepository;


    @Autowired
    private DonationRequestRepository donationRequestRepository;

    @Autowired
    @Lazy
    private DonationService donationService;

    public Optional<List<DonorList>> getAllDonors() {
        return Optional.of(donorListRepository.findAll());
    }

    public Optional<List<DonorList>> getDonorByDonorName(String donorName) {
        return Optional.of(donorListRepository.findByIdDonorName(donorName));
    }

    public Optional<List<DonorList>> getDonorsById(int donationId) {
        return Optional.of(donorListRepository.findByIdDonationId(donationId));
    }

    @Transactional
    public Optional<DonorList> postDonation(DonationRequestDTO donorData) {
        int donationId = donorData.getDonationId();
        long amount = donorData.getDonationAmount();

        Optional<DonationRequest> donationRequest = donationRequestRepository.findById(donationId);
        String donationName;
        if(donationRequest.isPresent()){
            DonationRequest donationRequest1 = donationRequest.get();
            long amount1 = donationRequest1.getCollectedAmount();
            amount1+=amount;
            donationRequest1.setCollectedAmount(amount1);
            donationRequestRepository.save(donationRequest1);
        }

        DonorListId donorListId = new DonorListId();
        donorListId.setDonationId(donationId);
        donorListId.setDonorName(donorData.getDonorName());

        if(donorListRepository.existsById(donorListId)){
            DonorList donorList = (donorListRepository.findById(donorListId)).get();
            long amount1 = donorList.getDonationAmount();
            amount1+=amount;
            donorList.setDonationAmount(amount1);
            List<String> transactionId = donorList.getTransactionId();
            transactionId.add(donorData.getTransactionId());
            donorList.setTransactionId(transactionId);

            return Optional.of(donorListRepository.save(donorList));

        }
        DonorList donorList = new DonorList();
        donorList.setDonationAmount(amount);
        donorList.setId(new DonorListId(donorData.getDonationId(), donorData.getDonorName()));
        List<String> transactionId = new ArrayList<>();
        transactionId.add(donorData.getTransactionId());
        donorList.setTransactionId(transactionId);

        if(donationRequest.isPresent()){
            DonationRequest donationRequest1 = donationRequest.get();
            donationName = donationRequest1.getDonationName();
            donorList.setDonationName(donationName);
        }


        return Optional.of(donorListRepository.save(donorList));
    }

    public Optional<DonorList> getDonorById(int donationId, String donorName) {
        DonorListId donorListId = new DonorListId(donationId, donorName);
        return donorListRepository.findById(donorListId);
    }

}
