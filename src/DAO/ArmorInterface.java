/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Armor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public interface ArmorInterface extends Remote{
   boolean createArmor(Armor dto) throws RemoteException ;
   Armor findByArmorID(String id) throws RemoteException ;
   List<Armor> findAllArmor() throws RemoteException ;
   boolean removeArmor(String id) throws RemoteException ;
   boolean updateArmor(Armor dto) throws RemoteException ;
}
