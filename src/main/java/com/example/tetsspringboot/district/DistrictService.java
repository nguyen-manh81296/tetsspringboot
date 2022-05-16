package com.example.tetsspringboot.district;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public District save(District district){
        districtRepository.save(district);
        return district;
    }

    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public Optional<District> findById(int cityId) {
        return districtRepository.findById(cityId);
    }

    public void deleteById(Integer id) {
        districtRepository.deleteById(id);
    }
}
