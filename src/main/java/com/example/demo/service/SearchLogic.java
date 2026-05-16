package com.example.demo.service;

import com.example.demo.entity.Surgery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public class SearchLogic {

    public static Specification<Surgery> hasPatientName(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("patient").get("fullName"), name);
    }

    public static Specification<Surgery> Within(LocalDate start, LocalDate end){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("schedule"), start, end);
    }
}
