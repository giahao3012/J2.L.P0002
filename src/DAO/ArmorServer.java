/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package DAO;

import DTO.Armor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import sun.util.calendar.CalendarUtils;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface{

    public static List<Armor> list;
    private String filename="ArmorData.txt";
    public ArmorServer() throws RemoteException
    {
        super();
        list= new ArrayList<>();
    }
    @Override
    public boolean createArmor(Armor dto) throws RemoteException {
       List<Armor>data=readFile(filename);
       if(data.add(dto))
       {
           writeFile(filename, data);
       }
       return true;
    }

    @Override
    public Armor findByArmorID(String id) throws RemoteException {
        try {
            List<Armor>data=readFile(filename);
            for (Armor armor : data) {
                if(armor.getArmorId().equals(id))
                {
                    return armor;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Armor> findAllArmor() throws RemoteException {
        List<Armor>data=readFile(filename);
        return data;
    }

      public int findByid(String id) {
        List<Armor> list = readFile(filename);
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getArmorId())) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean removeArmor(String id) throws RemoteException {
         List<Armor> list = readFile(filename);

        int pos = findByid(id);
        if (pos == -1) {

            return false;
        }
        System.out.println(pos);
        list.remove(pos);

        writeFile(filename, list);
        return true;
    }

    @Override
    public boolean updateArmor(Armor dto) throws RemoteException {
        try {
//        List<Armor>data=readFile(filename);
//        dto=findByArmorID(id);
        if(dto==null)
        {
            return false;
        }else{
        String newClass = null;
        int newDeferse = 0;
        String newDesciption = null;
        String newStatus = null;
        Date newTime = new Date();
        SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String d=sd.format(newTime);
            dto.setClassification(newClass);
            dto.setDefense(newDeferse);
            dto.setTimeOfCreate(sd.parse(d));
            dto.setDescription(newDesciption);
            dto.setStatus(newStatus);
//        
//           data.add(dto);
//           writeFile(filename, data);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
          return true;
    }
    public static void main(String[] args) {
        try {
            ArmorServer server=new ArmorServer();

            LocateRegistry.createRegistry(8888);
            Runtime r =Runtime.getRuntime();
            
            r.exec("rmiregistry.exe");
            Naming.rebind("rmi://127.0.0.1:8888/now", server);
            System.out.println("Server is ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Armor> readFile(String filename)
    {
        List<Armor> list=new ArrayList<>();
         try {
            File f = new File(filename);
            if(!f.exists()) {
                System.out.println("Can not found");
            }
            FileReader fr=new FileReader(f);
            BufferedReader bf=new BufferedReader(fr);
            SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String details;
            while((details=bf.readLine())!=null)
            {
                StringTokenizer stk=new StringTokenizer(details, ",");

                while(stk.hasMoreTokens())
                {
                 String ArmorId=stk.nextToken();
                 String Classification=stk.nextToken();
                 String Description=stk.nextToken();
                 String status=stk.nextToken();
                 String TimeOfCreate=stk.nextToken();
                 int Defense=Integer.parseInt(stk.nextToken());
                 Armor a=new Armor(ArmorId, Classification, Description, status, sd.parse(TimeOfCreate), Defense);
                 list.add(a);
                }

            }
            bf.close();
            fr.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return list;
    }
    public static void writeFile(String filename, List<Armor> listA)
    {
         try {
            File f = new File(filename);
            FileWriter fw=new FileWriter(f);
            PrintWriter pw=new PrintWriter(fw);
            for (Armor armor : listA) {
                pw.println(armor.toString());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
