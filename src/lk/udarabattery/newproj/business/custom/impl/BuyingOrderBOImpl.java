/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.business.custom.impl;

import java.util.ArrayList;
import lk.udarabattery.newproj.buisness.custom.BuyingorderBO;
import lk.udarabattery.newproj.dao.DAOFactory;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDAO;
import lk.udarabattery.newproj.dto.BuyingOrderDTO;
import lk.udarabattery.newproj.entity.BuyingOrder;

/**
 *
 * @author THARAKA
 */
public class BuyingOrderBOImpl implements BuyingorderBO{
    
    BuyingOrderDAO bodao=(BuyingOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BUYINGORDER);
    
    @Override
    public boolean saveBuyingOrder(BuyingOrderDTO bo) throws Exception {
       BuyingOrder bomOrder=new BuyingOrder(bo.getOrdid(), bo.getCusid(), bo.getOrddate());
       return bodao.save(bomOrder);
    }


    @Override
    public BuyingOrderDTO findID(String id) throws Exception {
        BuyingOrder bomOrder=bodao.findID(id);
        BuyingOrderDTO bOr=new BuyingOrderDTO(bomOrder.getOrdid(), bomOrder.getCusid(), bomOrder.getOrddate());
        return bOr;
    }

    @Override
    public ArrayList<BuyingOrderDTO> getAllBuyingOrder() throws Exception {
        ArrayList<BuyingOrder> al=bodao.loadAll();
       ArrayList<BuyingOrderDTO> s=new ArrayList<>();
       
        for (BuyingOrder buyingOrder : al) {
            BuyingOrderDTO bOr=new BuyingOrderDTO(buyingOrder.getOrdid(), buyingOrder.getCusid(), buyingOrder.getOrddate());
            s.add(bOr);
            
        }
        return s;
    }

    @Override
    public boolean deleteBuyingOrder(String id) throws Exception {
        return bodao.delete(id);
    }
    
}
