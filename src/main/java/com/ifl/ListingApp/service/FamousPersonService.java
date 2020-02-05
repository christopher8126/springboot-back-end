package com.ifl.ListingApp.service;

import com.ifl.ListingApp.dao.FamousPersonDao;
import com.ifl.ListingApp.model.FamousPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FamousPersonService {
    private final FamousPersonDao famousPersonDao;

//    wired constructor
    @Autowired
    public FamousPersonService(@Qualifier("dao") FamousPersonDao famousPersonDao) {
        this.famousPersonDao = famousPersonDao;
    }

//    ADD FAMOUS PERSON SERVICE
    public FamousPerson addFamousPerson(FamousPerson famousPerson){
        return famousPersonDao.insertFamousPerson(famousPerson);
    }

//    SELECT ALL FAMOUS PERSON
    public List<FamousPerson> getAllFamousPerson(){
        return famousPersonDao.selectAllFamousPeople();
    }

//    GET A SINGLE FAMOUS PERSON BY ID
    public Optional<FamousPerson> getFamousPersonById(UUID id){
        return famousPersonDao.selectFamousPersonById(id);
    }

//    DELETE A FAMOUS PERSON BY ID
    public int deleteFamousPerson(UUID id){
        return famousPersonDao.deleteFamousPersonById(id);
    }

//    UPDATE A FAMOUS PERSON BY SELECTED ID
    public int updateFamousPerson(UUID id, FamousPerson newFamousPerson){
        return famousPersonDao.updateFamousPersonById(id, newFamousPerson);
    }
}
