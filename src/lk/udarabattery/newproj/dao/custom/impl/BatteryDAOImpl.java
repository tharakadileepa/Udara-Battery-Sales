/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.udarabattery.newproj.dao.CrudUtil;
import lk.udarabattery.newproj.dao.custom.BatteryDAO;
import lk.udarabattery.newproj.entity.Battery;

/**
 *
 * @author THARAKA
 */
public class BatteryDAOImpl implements BatteryDAO{

    @Override
    public boolean save(Battery entity) throws Exception {
        return CrudUtil.executeUpdate("Insert Into battery values(?,?,?)", entity.getBcode(),entity.getBtype(),entity.getBcategory());
    }

    @Override
    public boolean delete(String id) throws Exception {
          return CrudUtil.executeUpdate("Delete from battery where bcode=?",id);
    }

    @Override
    public ArrayList<Battery> loadAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from battery");
        ArrayList<Battery> al=new ArrayList<>();
        
        while(rst.next()){
            Battery b=new Battery(rst.getString(1),rst.getString(2),rst.getString(3));
            al.add(b);
        }
        return al;
    }

    @Override
    public Battery findID(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from battery where bcode=?",id);
        
        if (rst.next()){
            return new Battery(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        else{
            return null;
        }
    }
    
}
