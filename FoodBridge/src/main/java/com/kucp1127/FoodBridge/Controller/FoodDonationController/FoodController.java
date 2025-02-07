package com.kucp1127.FoodBridge.Controller.FoodDonationController;

import com.kucp1127.FoodBridge.Model.FoodDonationModel.FoodDonation;
import com.kucp1127.FoodBridge.Service.FoodDonationService.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodDonationService;

    @GetMapping("/FoodDonations")
    public ResponseEntity<?> getAllFoodDonation(){
        Optional<List<FoodDonation>> foodDonationList = foodDonationService.getAllFoodDonation();
        if(foodDonationList.isPresent()) return new ResponseEntity<>(foodDonationList.get() , HttpStatus.OK);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @DeleteMapping("/FoodDonations/{id}")
    public ResponseEntity<?> deleteADonation(@PathVariable int id){
        Boolean b = foodDonationService.deleteADonation(id);
        if(b) return new ResponseEntity<>(null,HttpStatus.OK);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/FoodDonations/{id}")
    public ResponseEntity<?> getFoodDonationById(@PathVariable int id){
        Optional<FoodDonation> foodDonation = foodDonationService.getFoodDonationById(id);
        if(foodDonation.isPresent()) return new ResponseEntity<>(foodDonation.get() , HttpStatus.OK);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/FoodDonations")
    public ResponseEntity<?> postFoodDonation(@RequestBody FoodDonation foodDonation){
        Optional<FoodDonation> foodDonation1 = foodDonationService.postFoodDonation(foodDonation);
        if(foodDonation1.isPresent()) return new ResponseEntity<>(foodDonation1.get() , HttpStatus.OK);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/FoodDonations/{id}")
    public ResponseEntity<?> UpdateFoodDonation(@RequestBody FoodDonation foodDonation , @PathVariable int id){
        Optional<FoodDonation> foodDonation1 = foodDonationService.upDateFoodDonation(foodDonation , id);
        if(foodDonation1.isPresent()) return new ResponseEntity<>(foodDonation1.get() , HttpStatus.OK);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}