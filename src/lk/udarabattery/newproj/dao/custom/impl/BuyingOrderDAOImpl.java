/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.udarabattery.newproj.dao.CrudUtil;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDAO;
import lk.udarabattery.newproj.entity.BuyingOrder;

/**
 *
 * @author THARAKA
 */
public class BuyingOrderDAOImpl implements BuyingOrderDAO{

    @Override
    public boolean save(BuyingOrder entity) throws Exception {
        return CrudUtil.executeUpdate("Insert Into buyingorder Values(?,?,?)",entity.getCusid(),entity.getOrdid(),entity.getOrddate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from buyingorder where ordid=?",id);
    }

    @Override
    public ArrayList<BuyingOrder> loadAll() throws Exception {
       ResultSet rst = CrudUtil.executeQuery("select * from buyingorder");
       ArrayList<BuyingOrder> al=new ArrayList<>();
        
        while(rst.next()){
            BuyingOrder b=new BuyingOrder(rst.getString(1),rst.getString(2),rst.getDate(3));
            al.add(b);
        }
        return al;
    }

    @Override
    public BuyingOrder findID(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from buyingorder where ordid=?",id);
        
        if (rst.next()){
            return new BuyingOrder(rst.getString(1),rst.getString(2),rst.getDate(3));
        }
        else{
            return null;
        }
    }
    
}
