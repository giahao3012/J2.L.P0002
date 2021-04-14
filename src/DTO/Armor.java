/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class Armor implements Serializable{
    String ArmorId;
    String Classification;
    String Description;
    String status;
    Date TimeOfCreate;
    int Defense;

    public Armor() {
        
    }

    public Armor(String ArmorId, String Classification, String Description, String status, Date TimeOfCreate, int Defense) {
        this.ArmorId = ArmorId;
        this.Classification = Classification;
        this.Description = Description;
        this.status = status;
        this.TimeOfCreate = TimeOfCreate;
        this.Defense = Defense;
    }
    public String getArmorId() {
        return ArmorId;
    }

    public void setArmorId(String ArmorId) {
        this.ArmorId = ArmorId;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTimeOfCreate(Date TimeOfCreate) {
        this.TimeOfCreate = TimeOfCreate;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    @Override
    public String toString() {
        return ArmorId+","+Classification+","+Description+","+status+","+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(TimeOfCreate)+","+Defense;
    }
    
}
