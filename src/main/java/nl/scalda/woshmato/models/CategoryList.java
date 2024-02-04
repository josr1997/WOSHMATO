/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.woshmato.models;

import java.util.ArrayList;
import nl.scalda.woshmato.datalayer.DAOCategory;

/**
 *
 * @author kevin
 */
public class CategoryList {
    private static CategoryList instance;
    private ArrayList<Category> categories = DAOCategory.getInstance().getCategories();

    public CategoryList(){
        
    }
    
    public CategoryList(ArrayList<Category> categories){
        this.categories = categories;
    }
    
    public void createCategory(Category c){
        categories.add(c);
        DAOCategory.getInstance().createCategory(c);
    }
    
    public void editCategory(Category c){
        DAOCategory.getInstance().editCategory(c);
    }
    
    public void removeCategory(Category c){
        DAOCategory.getInstance().removeCategory(c);
        c = null;
    }
    
    public static CategoryList getInstance() {
        if(instance == null){
            instance = new CategoryList();
        }
        return instance;
    }

    public static void setInstance(CategoryList instance) {
        CategoryList.instance = instance;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    
    
}
