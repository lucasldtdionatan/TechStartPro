package com.techstartpro.lucastorrestest.service;

import com.techstartpro.lucastorrestest.model.Category;
import com.techstartpro.lucastorrestest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    String line = "";

    public void saveCategoryData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/category.csv"));
            while ((line = br.readLine()) != null ){
                String [] data = line.split(",");
                Category c = new Category();

                c.setName(data[0]);

                categoryRepository.save(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
