/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.business.custom.impl;

import java.util.ArrayList;
import lk.udarabattery.newproj.buisness.custom.CustomerBO;
import lk.udarabattery.newproj.dao.DAOFactory;
import lk.udarabattery.newproj.dao.custom.CustomerDAO;
import lk.udarabattery.newproj.dto.CustomerDTO;
import lk.udarabattery.newproj.entity.Customer;

/**
 *
 * @author THARAKA
 */
public class CustomerBOImpl implements CustomerBO{

    CustomerDAO cdto=(CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        Customer cus=new Customer(dto.getCusid(), dto.getCusname(), dto.getNicno(), dto.getCuscontact(), dto.getCusaddress());
        return cdto.save(cus);
                
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> cus=cdto.loadAll();
        ArrayList<CustomerDTO> cusg=new ArrayList<>();
        
        for (Customer cu : cus) {
            CustomerDTO cusd=new CustomerDTO(cu.getCusid(), cu.getCusname(), cu.getNicno(), cu.getCuscontact(), cu.getCusaddress());
            cusg.add(cusd);
        }
        return cusg;
    }

    @Override
    public boolean deleteCustomer(String Id) throws Exception {
        return cdto.delete(Id);
    }

    @Override
    public CustomerDTO findID(String id) throws Exception {
        Customer cusm=cdto.findID(id);
        CustomerDTO cusdo=new CustomerDTO(cusm.getCusid(), cusm.getCusname(), cusm.getNicno(), cusm.getCuscontact(),cusm.getCusaddress());
        return cusdo;
    }
    
}
