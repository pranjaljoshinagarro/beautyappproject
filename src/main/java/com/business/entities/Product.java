package com.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String pname;
    private double pprice;
    private String pdescription;

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public double getPprice() {
        return pprice;
    }
    public void setPprice(double pprice) {
        this.pprice = pprice;
    }
    public String getPdescription() {
        return pdescription;
    }
    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname +
               ", pprice=" + pprice + ", pdescription=" + pdescription + "]";
    }
}

