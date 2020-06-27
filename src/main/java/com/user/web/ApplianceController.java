package com.user.web;

import com.sipios.springsearch.anotation.SearchSpec;
import com.user.config.JwtUtil;
import com.user.exception.RecordNotFoundException;
import com.user.exception.RecordWithSameBrandException;
import com.user.exception.RecordWithSameModelException;
import com.user.model.ApplianceEntity;
import com.user.model.AuthenticationRequest;
import com.user.model.AuthenticationResponse;
import com.user.model.UserDto;
import com.user.repository.ApplianceRepository;
import com.user.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class ApplianceController {


    @Autowired
    private ApplianceRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Get the entire list of appliances
     **/

    @GetMapping("/hello")
    public String getValue(){
        return "Hello";
    }
    @GetMapping("/appliances")
    public List<ApplianceEntity> getAllAppliances() {

        return repository.findAll();

    }

    /**
     * Create a new appliance
     **/

    @PostMapping("/appliances")
    public ApplianceEntity createAppliance(@Valid @RequestBody ApplianceEntity appliance) throws RecordWithSameModelException, RecordWithSameBrandException {


        return repository.save(appliance);


    }

    /**
     * Get the appliance by Serial Number
     **/

    @GetMapping("appliances/{id}")
    public ResponseEntity<ApplianceEntity> getApplianceById(@PathVariable(value = "id") Long serialNo)
            throws RecordNotFoundException {
        ApplianceEntity appliance = repository.findById(serialNo)
                .orElseThrow(() -> new RecordNotFoundException("Appliance not found for this id :: " + serialNo));
        return ResponseEntity.ok().body(appliance);
    }


    /*** Search the appliance by brand/Model/status ***/

    @GetMapping("appliances/search")
    public ResponseEntity<List<ApplianceEntity>> searchForAppliances(@SearchSpec Specification<ApplianceEntity> specs) {

        return new ResponseEntity<>(repository.findAll(Specification.where(specs)), HttpStatus.OK);

    }

    /*** Update the appliance by brand,Model,status ***/

    @PostMapping("appliances/update/{id}")
    public ResponseEntity<ApplianceEntity> updateAppliances(@PathVariable(value = "id") Long serialNo,
                                                            @Valid @RequestBody ApplianceEntity applianceDetails) throws RecordNotFoundException {

        ApplianceEntity applianceEntity = repository.findById(serialNo)
                .orElseThrow(() -> new RecordNotFoundException("Appliance not found for this id :: " + serialNo));

        applianceEntity.setBrand(applianceDetails.getBrand());
        applianceEntity.setModel(applianceDetails.getModel());
        applianceEntity.setStatus(applianceDetails.getStatus());
        applianceEntity.setDate(LocalDate.now());
        final ApplianceEntity updatedAppliance = repository.save(applianceEntity);
        return ResponseEntity.ok(updatedAppliance);
    }

    /*** Delete appliance by Serial no ***/

    @DeleteMapping("appliances/delete/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long serialNo)
            throws ResourceNotFoundException {
        ApplianceEntity employee = repository.findById(serialNo)
                .orElseThrow(() -> new ResourceNotFoundException("Appliance not found for this id :: " + serialNo));

        repository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (Exception e) {

            throw new Exception("Details not found");

        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(myUserDetailsService.save(userDto));
    }

}
