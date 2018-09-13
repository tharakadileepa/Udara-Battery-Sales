/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.udarabattery.newproj.dao.CrudUtil;
import lk.udarabattery.newproj.dao.custom.CustomerDAO;
import lk.udarabattery.newproj.dto.CustomerDTO;
import lk.udarabattery.newproj.entity.Customer;

/**
 *
 * @author THARAKA
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean save(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("Insert Into customer values(?,?,?,?,?)",entity.getCusid(),entity.getCusname(),entity.getNicno(),entity.getCuscontact(),entity.getCusaddress());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from customer where cusid=?",id);
    }

    @Override
    public ArrayList<Customer> loadAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from customer");
        ArrayList<Customer> al=new ArrayList<>();
        
        while(rst.next()){
            Customer c=new Customer(rst.getString(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5));
            
            al.add(c);
        }
        return al;
    }

    @Override
    public Customer findID(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from customer where cusid=?",id);
        
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
        }
        else{
            return null;
        }
    }
    
}
