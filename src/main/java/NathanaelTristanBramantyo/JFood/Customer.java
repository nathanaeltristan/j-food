package NathanaelTristanBramantyo.JFood;
/**
 * Class Customer berisi id, nama, email, password, dan tanggal join dari customer.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

import java.util.*;
import java.util.regex.*;
import java.text.*;

public class Customer
{
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;


    /**
     * Constructor for objects of class Customer
     * @param id variable for identifying Customer
     * @param name variable to store name information of customer
     * @param email variable to store email information
     * @param password variable to store password
     * @param joinDate variable to store join date of customer
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate.add(Calendar.MONTH,-1);
    }

    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.joinDate = Calendar.getInstance();
        setEmail(email);
        setPassword(password);
    }

    
    /**
     * Method as accessor to get id of the costumer
     * @return id variable that stores id of customer
     */
    public int getId()
    {
        return id;
    }
    
    /**
    * Method as accessor to get name of the customer
    * @return name variable that stores name of customer
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Method as accessor to get email of the customer
    * @return email variable that stores email of customer
    */
    public String getEmail()
    {
        return email;
    }
    
    /**
    * Method as accessor to get password of the customer
    * @return password variable that stores password of the customer
    */
    public String getPassword()
    {
        return password;
    }
    
    /**
    * Method as accessor to get the join date of the customer
    * @return joinDate variable that stores information of join date of the customer
    */
    public Calendar getJoinDate()
    {
        return joinDate;
    }
    
    
    /**
    * Method as setter or mutator to set or change id of customer
    */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
    * Method as setter or mutator to set or change name of customer
    */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
    * Method as setter or mutator to set or change name of customer
    */
    public void setEmail(String email)
    {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==true)
        {
            this.email = email;
        }
        
        else
        {
            this.email = "";
        }   
    }

    /**
    * Method as setter or mutator to set or change password of customer
    */
    public void setPassword(String password)
    {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()==true)
        {
            this.password = password;
        }
        
        else
        {
            this.password = "";
        }   
    }

    /**
    * Method as setter or mutator to set or change join date of customer
    */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }

    /**
    * Method as setter or mutator to set or change join date of customer
    */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    
    /**
    * Method to set all variables of Customer to String
    */
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return "===Customer==="+
                "\nId: "+id+
                "\nNama: "+name+
                "\nEmail: "+email+
                "\nJoinDate :"+sdf.format(getJoinDate().getTime())+
                "\nPassword: "+password;
    }
}