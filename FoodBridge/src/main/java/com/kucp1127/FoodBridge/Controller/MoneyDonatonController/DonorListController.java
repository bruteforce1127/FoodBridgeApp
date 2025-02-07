package com.kucp1127.FoodBridge.Controller.MoneyDonatonController;


import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonationRequestDTO;
import com.kucp1127.FoodBridge.Model.MoneyDonationModel.DonorList;
import com.kucp1127.FoodBridge.Service.MoneyDonatonService.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DonorListController {

    @Autowired
    private DonorService donorService;


    @GetMapping("/Donors")
    private ResponseEntity<List<DonorList>> getAllDonors(){
        Optional<List<DonorList>> listOfDonors = donorService.getAllDonors();
        if(listOfDonors.isPresent()) return new ResponseEntity<>(listOfDonors.get() , HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/Donors/byName/{donorName}")
    private ResponseEntity<List<DonorList>> getDonorByDonorName(@PathVariable String donorName){
        Optional<List<DonorList>> listOfDonors = donorService.getDonorByDonorName(donorName);
        if(listOfDonors.isPresent()) return new ResponseEntity<>(listOfDonors.get() , HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @GetMapping("/Donors/byId/{donationId}")
    private ResponseEntity<List<DonorList>> getDonorsById(@PathVariable int donationId){
        Optional<List<DonorList>> listOfDonors = donorService.getDonorsById(donationId);
        if(listOfDonors.isPresent()) return new ResponseEntity<>(listOfDonors.get() , HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/Donors/{donationId}/{donorName}")
    public ResponseEntity<?> getDonorById(@PathVariable int donationId, @PathVariable String donorName) {
        Optional<DonorList> donor = donorService.getDonorById(donationId, donorName);
        return donor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/Donors")
    private ResponseEntity<?> postDonation(@RequestBody DonationRequestDTO donorData){
        Optional<DonorList> donor = donorService.postDonation(donorData);
        if(donor.isPresent()) return new ResponseEntity<>(donor.get() , HttpStatus.CREATED);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }



}
