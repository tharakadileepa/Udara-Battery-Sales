/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.business.custom.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import lk.udarabattery.newproj.buisness.custom.OrderBO;
import lk.udarabattery.newproj.dao.DAOFactory;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDAO;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDetailDAO;
import lk.udarabattery.newproj.database.DBconnection;
import lk.udarabattery.newproj.dto.BuyingOrderDTO;
import lk.udarabattery.newproj.dto.BuyingOrderDetailDTO;

/**
 *
 * @author THARAKA
 */
public class OrderBOimpl implements OrderBO{

   private BuyingOrderBOImpl bOImpl;
   private BuyingOrderDetailBOImpl bOdImpl;

    public OrderBOimpl() {
        this.bOImpl=new BuyingOrderBOImpl();
        this.bOdImpl=new BuyingOrderDetailBOImpl();
    }

  
   
   
    
    @Override
    public boolean placeorder(BuyingOrderDTO bo, BuyingOrderDetailDTO bod) throws Exception {
        
       Connection con=null;
       try{
       con = DBconnection.getInstance().getConnection();
       con.setAutoCommit(false);
         BuyingOrderDTO bb=new BuyingOrderDTO(bo.getOrdid(), bo.getCusid(), bo.getOrddate());
         boolean result1 = bOImpl.saveBuyingOrder(bb);
         
            if (result1 == true) {
               
               BuyingOrderDetailDTO detailDTO=new BuyingOrderDetailDTO(bod.getBcode(), bod.getOrdid(),bod.getBprice());
               boolean result2 = bOdImpl.saveBuyingOrderDetail(detailDTO);
                    
                    if (result2) {
                        con.commit();
                        return true;
                    }
                    else{
                        con.rollback();
                        return  result2;
                    }
       
            } else {
                con.rollback();
                return false;

            }

        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
           
            con.setAutoCommit(true);
       
        }
      

    }

}
       