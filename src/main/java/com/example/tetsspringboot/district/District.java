package com.example.tetsspringboot.district;

import com.example.tetsspringboot.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="districts")
public class District extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int    id;
    private String name;
    private int    cityId;
    private String totalPopular;
    private String phone;
    private String fax;
    private int    status;
    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL)
    private Set<DistrictStreet> districtStreetSet;
}
