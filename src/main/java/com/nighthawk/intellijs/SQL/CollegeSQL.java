package com.nighthawk.intellijs.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeSQL {

    @Autowired
    private CollegeJPA jpa;


    public  List<College>listAll() {
        return jpa.findAll();
    }

       // custom query to find anything containing term in name or email ignoring case
    public  List<College>listLikeNative(String term) {
        String like_term = String.format("%%%s%%",term);  // Like required % rappers
        return jpa.findByLikeTermNative(like_term);
    }

    public void save(College college) {
        jpa.save(college);
    }

    public College get(long id) {
        return (jpa.findById(id).isPresent())
                ? jpa.findById(id).get()
                : null;
    }

//    public void delete(long id) {
//        jpa.deleteById(id);
//    }
}