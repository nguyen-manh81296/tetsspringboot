package com.example.tetsspringboot.district;

import com.example.tetsspringboot.street.Street;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "districts_streets")
public class DistrictStreet {
    @EmbeddedId
    private DistrictStreetId id;

    @ManyToOne
    @MapsId("districtId")
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    @ManyToOne
    @MapsId("streetId")
    @JoinColumn(name = "street_id",nullable = false)
    private Street street;



}
