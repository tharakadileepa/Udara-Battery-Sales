/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.udarabattery.newproj.dao.CrudUtil;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDetailDAO;
import lk.udarabattery.newproj.entity.BuyingOrderDetail;
import lk.udarabattery.newproj.entity.BuyingOrderDetail_PK;

/**
 *
 * @author THARAKA
 */
public class BuyingOrderDetailDAOImpl implements BuyingOrderDetailDAO{

    @Override
    public boolean save(BuyingOrderDetail entity) throws Exception {
        return CrudUtil.executeUpdate("Insert Into buyingorderdetail Values(?,?,?)",entity.getBuyingOrderDetail_PK().getBcode(),entity.getBuyingOrderDetail_PK().getOrdid(),entity.getBprice());
    }

    @Override
    public boolean delete(BuyingOrderDetail_PK id) throws Exception {
        return CrudUtil.executeUpdate("Delete from  where bcode=? and ordid=?",id.getBcode(),id.getOrdid());
    }

    @Override
    public ArrayList<BuyingOrderDetail> loadAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select * from buyingorderdetail");
        ArrayList<BuyingOrderDetail> al=new ArrayList<>();
        
        while(rst.next()){
            BuyingOrderDetail bod=new BuyingOrderDetail(rst.getString(1),rst.getString(2),rst.getBigDecimal(3));
            al.add(bod);
        }
        return al;
    }

    @Override
    public BuyingOrderDetail findID(BuyingOrderDetail_PK id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from buyingorderdetail where bcode=? and ordid=?",id.getBcode(),id.getOrdid());
        
        if (rst.next()){
            return new BuyingOrderDetail(rst.getString(1),rst.getString(2), rst.getBigDecimal(3));
        }
        else{
            return null;
        }
    }
    
}
