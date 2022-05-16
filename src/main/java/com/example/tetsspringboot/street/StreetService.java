package com.example.tetsspringboot.street;

import com.example.tetsspringboot.district.DistrictStreet;
import com.example.tetsspringboot.district.DistrictStreetId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    public Page<Street> findAll(int page, int limit) {
        return streetRepository.findAll(
                PageRequest.of(page - 1, limit));
    }

    public List<Street> getAll() {
        return streetRepository.findAll();
    }
//
//    public List<Street> findByNameAndPrice(String name, double price) {
//        return productRepository.findAllByNameContainsAndPriceLessThanEqual(name, price);
//    }

    public Optional<Street> findById(Integer id) {
        return streetRepository.findById(id);
    }

    public Street save(Street street) {
        return streetRepository.save(street);
    }

    public void deleteById(Integer id) {
        streetRepository.deleteById(id);
    }

    public boolean addProductToClass(District district, Street street) {
        try{

        Set<DistrictStreet> districtStreets = street.getDistrictStreetSet();
        if (districtStreets == null) {
            districtStreets = new HashSet<>();
        }
        DistrictStreet districtStreet = new DistrictStreet();
        districtStreet.setId(new DistrictStreetId(district.getId(), street.getId()));
        districtStreet.setDistrict(district);
        districtStreet.setStreet(street);
        districtStreet.add(districtStreet);
        street.setDistrictStreetSet(districtStreet);
        streetRepository.save(street);
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
        return true;
    }
}
