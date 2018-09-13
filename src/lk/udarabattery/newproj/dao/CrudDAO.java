/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.dao;

import java.util.ArrayList;

/**
 *
 * @author THARAKA
 */
public interface CrudDAO<T,ID> extends SuperDAO{
    
    public boolean save(T entity)throws Exception;
    public boolean delete(ID id)throws Exception;
    public ArrayList<T> loadAll() throws Exception;
    public T findID(ID id)throws Exception;
   
}
