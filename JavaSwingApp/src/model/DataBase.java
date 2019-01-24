package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataBase
{
    private List<Customer> arr_of_customer;

    public DataBase()
    {
        arr_of_customer = new LinkedList<Customer>();
    }

    public void addCustomer(Customer customer)
    {
        this.arr_of_customer.add(customer);
    }
    
    public void removeCustomer(int index)
    {
    	arr_of_customer.remove(index);
    }

    public List<Customer> getCustomer()
    {
        return Collections.unmodifiableList(arr_of_customer);
    }
    
    public void saveToFile(File file) throws IOException
    {
    	FileOutputStream fos = new FileOutputStream(file);
    	ObjectOutputStream oos = new ObjectOutputStream(fos);
    	
    	Customer[] customers = arr_of_customer.toArray(new Customer[arr_of_customer.size()]);
    	
    	oos.writeObject(customers);
    	
    	oos.close();
    }
    
    public void loadFromFile(File file) throws IOException, ClassNotFoundException
    {
    	FileInputStream fis = new FileInputStream(file);
    	ObjectInputStream ois = new ObjectInputStream(fis);
    
    	
    	Customer[] customers = (Customer[])ois.readObject();
    	
    	arr_of_customer.clear();
    	
    	arr_of_customer.addAll(Arrays.asList(customers));
    	
    	
    	
    	
    	ois.close();
    }
}