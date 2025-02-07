package com.kucp1127.FoodBridge.Model.MoneyDonationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorList {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "donationId", column = @Column(name = "donation_id")),
            @AttributeOverride(name = "donorName", column = @Column(name = "donor_name"))
    })
    private DonorListId id;
    private long donationAmount;
    private String donationName;
    @ElementCollection
    private List<String> transactionId;
    @Version
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private int version;
}


