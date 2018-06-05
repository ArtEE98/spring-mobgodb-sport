package com.example.springmobgodbsport.document;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Order {



    @Id
    private Integer id;
    @Indexed(unique = true)
    private String managerName;
    private String organization;
    private Integer numberOfAthlets;
    private String country;
    private String status;
    private Requirements requirements;

    public Order(Integer id, String managerName, String organization, Integer numberOfAthlets, String country,
                 String status, Requirements requirements) {
        this.id = id;
        this.managerName = managerName;
        this.organization = organization;
        this.numberOfAthlets = numberOfAthlets;
        this.country = country;
        this.status = status;
        this.requirements = requirements;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getNumberOfAthlets() {
        return numberOfAthlets;
    }

    public void setNumberOfAthlets(Integer numberOfAthlets) {
        this.numberOfAthlets = numberOfAthlets;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Requirements getRequirements() {
        return requirements;
    }

    public void setRequirements(Requirements requirements) {
        this.requirements = requirements;
    }
}
