package com.example.tetsspringboot.district;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/districts")
public class DistrictApi {
    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.POST)
    public District save(@RequestBody District district) {
        return districtService.save(district);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<District> findAll(){
        return districtService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public District getDetail(@PathVariable int id) {
        return districtService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        districtService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public District update(@PathVariable int id, @RequestBody District updateDistrict) {
        District existing = districtService.findById(id).get();
        existing.setName(updateDistrict.getName());
        existing.setCityId(updateDistrict.getCityId());
        existing.setTotalPopular(updateDistrict.getTotalPopular());
        existing.setPhone(updateDistrict.getPhone());
        existing.setFax(updateDistrict.getFax());
        existing.setStatus(updateDistrict.getStatus());
        districtService.save(existing);
        return updateDistrict;
    }
}

