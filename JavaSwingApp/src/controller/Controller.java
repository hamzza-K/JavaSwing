package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import gui.FormEvent;

import model.DataBase;
import model.AgeCategory;
import model.Customer;
import model.EmployementCategory;
import model.Gender;


public class Controller {
	
	DataBase db = new DataBase();
	

    public List<Customer> getCustomer()
    {
        return db.getCustomer();
    }
    
    public void removeCustomer(int index)
    {
    	db.removeCustomer(index);
    }

    

    public void addCustomer(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();

        int ageCatid = e.getAgeCategory();
        String empCat = e.getEmployementCategory();

        boolean ispaki = e.isPakistani();
        String nicId = e.getNicId();
        String gender = e.getGender();
        

        AgeCategory ageCategory = null;

        switch(ageCatid)
        {
            case 0:
                ageCategory = AgeCategory.CHILD;
                break;
            case 1:
                ageCategory = AgeCategory.ADULT;
                break;
            case 2:
                ageCategory = AgeCategory.SENIOR;
                break;
        }

        EmployementCategory empCategory;

        if(empCat.equals("employed"))
        {
            empCategory = EmployementCategory.EMPLOYED;
        }
        else if(empCat.equals("self-employed"))
        {
            empCategory = EmployementCategory.SELFEMPLOYED;
        }
        else if(empCat.equals("unemployed"))
        {
            empCategory = EmployementCategory.UNEMPLOYED;
        }
        else
        {
            empCategory = EmployementCategory.OTHER;
            System.err.println(empCat);
        }

        Gender genderCat;

        if(gender.equals("Male"))
        {
            genderCat = Gender.MALE;
        }
        else
        {
            genderCat = Gender.FEMALE;
        }

        Customer customer = new Customer(name, occupation, ageCategory, empCategory, nicId, ispaki, genderCat);
        
        db.addCustomer(customer);

    }
    
    public void saveToFile(File file) throws IOException
    {
    	db.saveToFile(file);
    }
    
    public void loadFromFile(File file) throws ClassNotFoundException, IOException
    {
    	db.loadFromFile(file);
    }



}
