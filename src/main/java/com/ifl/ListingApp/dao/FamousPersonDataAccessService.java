package com.ifl.ListingApp.dao;

import com.ifl.ListingApp.model.FamousPerson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("dao")
public class FamousPersonDataAccessService implements FamousPersonDao {

    private static List<FamousPerson> DB = new ArrayList<>();

//    @Override
//    public int insertFamousPerson(UUID id, FamousPerson famousPerson) {
//        DB.add(new FamousPerson(id, famousPerson.getName(), famousPerson.getBio()));
//        return 1;
//    }

    @Override
    public FamousPerson insertFamousPerson(UUID id, FamousPerson famousPerson) {
        DB.add(new FamousPerson(id, famousPerson.getName(), famousPerson.getBio()));
        return new FamousPerson(id, famousPerson.getName(), famousPerson.getBio());

    }

    @Override
    public List<FamousPerson> selectAllFamousPeople() {
        return DB;
    }

//    SELECT A FAMOUS PERSON BY ID
    @Override
    public Optional<FamousPerson> selectFamousPersonById(UUID id) {
        return DB.stream()
                .filter(famousPerson -> famousPerson.getId().equals(id))
                .findFirst();
    }

//    DELETE A FAMOUS PERSON BY ID
    @Override
    public int deleteFamousPersonById(UUID id) {
        Optional<FamousPerson> person = selectFamousPersonById(id);
        if(person.isEmpty()){
            return 0;
        }
        DB.remove(person.get());
        return 1;
    }

//    UPDATE A FAMOUS PERSON BY ID
    @Override
    public int updateFamousPersonById(UUID id, FamousPerson famousPerson) {
        return selectFamousPersonById(id)
                .map(famousPerson1 -> {
                    int indexOfFamousPerson = DB.indexOf(famousPerson1);
                    if(indexOfFamousPerson >= 0){
                        DB.set(indexOfFamousPerson, new FamousPerson(id, famousPerson.getName(), famousPerson.getBio()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
