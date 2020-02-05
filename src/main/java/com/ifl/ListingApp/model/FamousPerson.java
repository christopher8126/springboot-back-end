package com.ifl.ListingApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class FamousPerson {

    private final UUID id;

    @NonNull
    private final String name;
    @NonNull
    private final String bio;
//    to add Date of Birth Later


    public FamousPerson(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("bio") String bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }
}
