/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.udarabattery.newproj.buisness.custom.BuyingorderdetailBO;
import lk.udarabattery.newproj.dao.DAOFactory;
import lk.udarabattery.newproj.dao.custom.BuyingOrderDetailDAO;
import lk.udarabattery.newproj.dto.BuyingOrderDetailDTO;
import lk.udarabattery.newproj.entity.BuyingOrderDetail;
import lk.udarabattery.newproj.entity.BuyingOrderDetail_PK;

/**
 *
 * @author THARAKA
 */
public class BuyingOrderDetailBOImpl implements BuyingorderdetailBO{
    
    BuyingOrderDetailDAO aO=(BuyingOrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BUYINGORDERDETAIL);
    
    @Override
    public boolean saveBuyingOrderDetail(BuyingOrderDetailDTO bod) throws Exception {
        BuyingOrderDetail bm=new BuyingOrderDetail(bod.getBcode(), bod.getOrdid(), bod.getBprice());
        return aO.save(bm);
    }

   

    @Override
    public BuyingOrderDetailDTO findID(String bcode, String ordid) throws Exception {
        BuyingOrderDetail_PK bodpk=new BuyingOrderDetail_PK(bcode, ordid);
        BuyingOrderDetail bod=aO.findID(bodpk);
        BuyingOrderDetailDTO boddto=new BuyingOrderDetailDTO(bod.getBuyingOrderDetail_PK().getBcode(), bod.getBuyingOrderDetail_PK().getOrdid(), bod.getBprice());
        return boddto;
    }

    @Override
    public ArrayList<BuyingOrderDetailDTO> getAllBuyingOrder() throws Exception {
        ArrayList<BuyingOrderDetail> al=aO.loadAll();
        ArrayList<BuyingOrderDetailDTO> b=new ArrayList<>();
        
        for (BuyingOrderDetail buyingOrderDetail : al) {
            BuyingOrderDetailDTO boddto=new BuyingOrderDetailDTO(buyingOrderDetail.getBuyingOrderDetail_PK().getBcode(), buyingOrderDetail.getBuyingOrderDetail_PK().getOrdid(), buyingOrderDetail.getBprice());
            b.add(boddto);
        }
        return b;
    }

    @Override
    public boolean deleteBuyingOrderDetail(String bcode, String ordid) throws Exception {
        BuyingOrderDetail_PK bodpk=new BuyingOrderDetail_PK(bcode, ordid);
        return aO.delete(bodpk);
    }
    
}
