package com.example.tetsspringboot.street;

import com.example.tetsspringboot.district.DistrictStreet;
import com.example.tetsspringboot.entity.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int categoryId;
    private int status;

    @ManyToOne
    @JoinColumn(name = "CategoryId",insertable = false,updatable = false)
    private City category;

    @OneToMany(mappedBy = "street",cascade = CascadeType.ALL)
    private Set<DistrictStreet> cityStreetSet;

}
