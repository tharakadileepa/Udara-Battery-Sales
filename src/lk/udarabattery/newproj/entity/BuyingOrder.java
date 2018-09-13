/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.entity;

import java.util.Date;

/**
 *
 * @author THARAKA
 */
public class BuyingOrder {
    private String ordid;
    private String cusid;
    private Date orddate;

    public BuyingOrder() {
    }

    public BuyingOrder(String ordid, String cusid, Date orddate) {
        this.ordid = ordid;
        this.cusid = cusid;
        this.orddate = orddate;
    }

    /**
     * @return the ordid
     */
    public String getOrdid() {
        return ordid;
    }

    /**
     * @param ordid the ordid to set
     */
    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    /**
     * @return the cusid
     */
    public String getCusid() {
        return cusid;
    }

    /**
     * @param cusid the cusid to set
     */
    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    /**
     * @return the orddate
     */
    public Date getOrddate() {
        return orddate;
    }

    /**
     * @param orddate the orddate to set
     */
    public void setOrddate(Date orddate) {
        this.orddate = orddate;
    }

    @Override
    public String toString() {
        return "BuyingOrder{" + "ordid=" + ordid + ", cusid=" + cusid + ", orddate=" + orddate + '}';
    }
    
    
}
