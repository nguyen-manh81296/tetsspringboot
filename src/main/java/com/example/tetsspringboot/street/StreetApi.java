package com.example.tetsspringboot.street;

import com.example.tetsspringboot.district.District;
import com.example.tetsspringboot.district.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/streets")

public class StreetApi {
    @Autowired
    StreetService streetService;

    @Autowired
    DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Street> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "1") int limit) {
        return streetService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/get-all")
    public List<Street> getList() {
        return streetService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Street save(@RequestBody Street street) {
        streetService.save(street);
        return street;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Street getDetail(@PathVariable int id) {
        return streetService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        streetService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Street update(@PathVariable int id, @RequestBody Street updateStreet) {
        Street existing = streetService.findById(id).get();
        existing.setName(updateStreet.getName());
        existing.setDescription(updateStreet.getDescription());
        streetService.save(existing);
        return updateStreet;
    }

//    @RequestMapping(method = RequestMethod.GET, path = "add-street")
//    public ResponseEntity<?> addStreetToDistrict(
//            @RequestParam int orderId,
//            @RequestParam int cityId) {
//        Optional<Street> optionalStreet = streetService.findById(streetId);
//        // check sự tồn tại của order
//        Optional<District> optionalDistrict = districtService.findById(orderId);
//        // trả về not found nếu một trong 2 trường hợp không tìm thấy
//        if (!optionalStreet.isPresent() || !optionalDistrict.isPresent()) {
//            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
//        }
//        boolean resutlt = streetService.addDistrictToClass(optionalStreet.get(), optionalDistrict.get());
//        if (!resutlt) {
//            return new ResponseEntity<>("Add product error!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("Add product success!", HttpStatus.OK);
//    }
}
