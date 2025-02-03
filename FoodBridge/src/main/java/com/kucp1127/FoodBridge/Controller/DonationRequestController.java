package com.kucp1127.FoodBridge.Controller;

import com.kucp1127.FoodBridge.Model.DonationRequest;
import com.kucp1127.FoodBridge.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DonationRequestController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/getDonations")
    public ResponseEntity<List<DonationRequest>> getDonations(){
        List<DonationRequest> donations = donationService.getDonations();
        if(donations!=null) return new ResponseEntity<>(donations , HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getDonations/{id}")
    public ResponseEntity<DonationRequest> getDonationById(@PathVariable int id) {
        Optional<DonationRequest> donation = donationService.getDonationById(id);

        if (donation.isPresent()) {
            return new ResponseEntity<>(donation.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/deleteDonations/{id}")
    public ResponseEntity<Void> deleteDonationById(@PathVariable int id) {
        boolean b = donationService.deleteById(id);
        if (b) {
            return ResponseEntity.noContent().build(); // Returns HTTP 204 No Content
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Returns HTTP 500
    }

    @PostMapping("/postDonations")
    public ResponseEntity<DonationRequest> postDonation(@RequestBody DonationRequest donationData){
        Optional<DonationRequest> donation = donationService.postDonation(donationData);
        if (donation.isPresent()) {
            return new ResponseEntity<>(donation.get(), HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/putDonations")
    public ResponseEntity<DonationRequest> updateDonation(@RequestBody DonationRequest donationData){
        Optional<DonationRequest> donation = donationService.postDonation(donationData);
        if (donation.isPresent()) {
            return new ResponseEntity<>(donation.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
