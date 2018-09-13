/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.business.custom.impl;

import java.util.ArrayList;
import lk.udarabattery.newproj.buisness.custom.BatteryBO;
import lk.udarabattery.newproj.dao.DAOFactory;
import lk.udarabattery.newproj.dao.custom.BatteryDAO;
import lk.udarabattery.newproj.dto.BatteryDTO;
import lk.udarabattery.newproj.entity.Battery;

/**
 *
 * @author THARAKA
 */
public class BatteryBOImpl implements BatteryBO{
    
    BatteryDAO batteryDAO=(BatteryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BATTERY);

    @Override
    public boolean saveBattery(BatteryDTO battery) throws Exception {
        Battery b=new Battery(battery.getBcode(), battery.getBtype(),battery.getBcategory());
        return batteryDAO.save(b);
    }


    @Override
    public BatteryDTO findID(String id) throws Exception {
        Battery b=batteryDAO.findID(id);
        BatteryDTO batteryDTO=new BatteryDTO(b.getBcode(),b.getBtype(),b.getBcategory());
        return batteryDTO;
    }

    @Override
    public ArrayList<BatteryDTO> getAllBattery() throws Exception {
       ArrayList<Battery> al=batteryDAO.loadAll();
       ArrayList<BatteryDTO> s=new ArrayList<>();
       
        for (Battery battery : al) {
            BatteryDTO batteryDTO=new BatteryDTO(battery.getBcode(), battery.getBtype(),battery.getBcategory());
            s.add(batteryDTO);
            
        }
        return s;
    }

    @Override
    public boolean deleteBattery(String id) throws Exception {
        return batteryDAO.delete(id);
    }
    
}
