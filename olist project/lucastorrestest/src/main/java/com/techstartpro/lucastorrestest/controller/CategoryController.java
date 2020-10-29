package com.techstartpro.lucastorrestest.controller;

import com.techstartpro.lucastorrestest.model.Category;
import com.techstartpro.lucastorrestest.model.Product;
import com.techstartpro.lucastorrestest.repository.CategoryRepository;
import com.techstartpro.lucastorrestest.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value="Api rest products")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryServices;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/feedCategoryData")
    @ApiOperation(value="Read csv")
    public void setCategoryInDB(){
        categoryServices.saveCategoryData();
    }

    @GetMapping("/category")
    @ApiOperation(value="Return all categories")
    public List<Category> categorytList(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    @ApiOperation(value="Return category by id")
    public Optional<Category> findById(@PathVariable("id") long id){
        return categoryRepository.findById(id);
    }

    @PostMapping("/category")
    @ApiOperation(value="save category")
    public Category saveCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("/category")
    @ApiOperation(value = "update category")
    public void updateCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }

    @DeleteMapping("/category/{id}")
    @ApiOperation(value = "Delete category")
    public void deleteCategoryById(@PathVariable("id") long id){
        categoryRepository.deleteById(id);
    }
}
