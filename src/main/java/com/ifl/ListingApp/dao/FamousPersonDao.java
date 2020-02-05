package com.ifl.ListingApp.dao;

import com.ifl.ListingApp.model.FamousPerson;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FamousPersonDao {

    FamousPerson insertFamousPerson(UUID id, FamousPerson famousPerson);
    default FamousPerson insertFamousPerson(FamousPerson famousPerson){
        UUID id = UUID.randomUUID();
        return insertFamousPerson(id, famousPerson);
    }

    List<FamousPerson> selectAllFamousPeople();

    Optional<FamousPerson> selectFamousPersonById(UUID id);

    int deleteFamousPersonById(UUID id);

    int updateFamousPersonById(UUID id, FamousPerson famousPerson);

}
