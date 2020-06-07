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
     * @param id is to hold value of object's id
     * @param email is to hold value of object's email
     * @param password is to hold value of object's password
     * @param joinDate is to hold value of object's joinDate
     */
    public Customer(int id, String name, String email,
                    String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }

    public Customer(int id, String name, String email,
                    String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    public Customer(int id, String name, String email,
                    String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.password = password;
        this.joinDate = new GregorianCalendar();
    }

    /**
     * this is the getter of customer's id
     * @return id of the costumer
     */
    public int getId()
    {
        return id;
    }

    /**
     * this is the getter of customer's name
     * @return name of the customer
     */
    public String getName()
    {
        return name;
    }

    /**
     * this is the getter of customer's email
     * @return email of the customer
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * this is the getter of customer's password
     * @return password of the customer
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * this is the getter of the customer's join date
     * @return join date of the customer
     */
    public Calendar getJoinDate()
    {
        return joinDate;
    }

    /**
     * this is the setter of customer's id
     * @param id is the id of the customer
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * this is the setter of customer's id
     * @param name is the name of the customer
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * this is the setter of customer's email
     * @param email is the email of the customer
     */
    public void setEmail(String email)
    {
        String regex_rule = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex_rule);
        Matcher match = pattern.matcher(email);
        if(match.find())
        {
            this.email = email;
        }
        else
        {
            this.email = "";
        }
    }

    /**
     * this is the setter of customer's password
     * @param password is the password of the customer
     */
    public void setPassword(String password)
    {
        String regex_rule = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{6,})";
        Pattern pattern = Pattern.compile(regex_rule);
        Matcher match = pattern.matcher(password);
        if(match.find())
        {
            this.password = password;
        }
        else
        {
            this.password = "";
        }
    }

    /**
     * this is the setter of customer's join date
     * @param joinDate is the join date of the customer
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }

    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    /**
     * this method is to print any data in this class
     */
    public String toString()
    {
        String timeNow = "";

        if(joinDate != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            timeNow = sdf.format(joinDate.getTime());
        }

        return "\nId = " + getId() + "\nNama = " + getName() +
                "\nEmail = " + getEmail() + "\nPassword = " + getPassword() +
                "\nJoin Date = " + timeNow;

    }

}