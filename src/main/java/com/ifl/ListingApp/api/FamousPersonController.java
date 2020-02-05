package com.ifl.ListingApp.api;

import com.ifl.ListingApp.model.FamousPerson;
import com.ifl.ListingApp.service.FamousPersonService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/famous-person")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FamousPersonController {

    private  final FamousPersonService famousPersonService;

    @Autowired
    public FamousPersonController(FamousPersonService famousPersonService){
        this.famousPersonService = famousPersonService;
    }

    @PostMapping
    public FamousPerson addFamousPerson(@Valid @NonNull @RequestBody FamousPerson famousPerson){
        return famousPersonService.addFamousPerson(famousPerson);
    }

    @GetMapping
    public List<FamousPerson> getAllFamousPerson(){
        return famousPersonService.getAllFamousPerson();
    }

    @GetMapping(path = "{id}")
    public FamousPerson getFamousPersonById(@PathVariable("id") UUID id){
        return famousPersonService.getFamousPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFamousPersonById(@PathVariable("id") UUID id){
        famousPersonService.deleteFamousPerson(id);
    }

    @PutMapping(path ="{id}")
    public void updateFamousPerson(@PathVariable("id") UUID id,@Valid @NonNull @RequestBody FamousPerson famousPerson){
        famousPersonService.updateFamousPerson(id, famousPerson);
    }

}
