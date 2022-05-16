package com.example.tetsspringboot.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DistrictStreetId implements Serializable {
    @Column(name = "district_id")
    private int districtId;

    @Column(name = "street_id")
    private int streetId;
}
