/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author 🌸방탄소년단🌸
 */
public class LoginDAO {
    List<Users> list;
    private static String filename="Users.txt";
    public LoginDAO() {
        list=new ArrayList<>();
    }
    public static List<Users> readFile(String filename)
    {
        List<Users> list=new ArrayList<>();
         try {
            File f = new File(filename);
            if(!f.exists()) {
                System.out.println("Can not found");
            }
            FileReader fr=new FileReader(f);
            BufferedReader bf=new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null)
            {
                StringTokenizer stk=new StringTokenizer(details, ",");

                while(stk.hasMoreTokens())
                {
                 String username=stk.nextToken();
                 String password=stk.nextToken();
                 Users u=new Users(username, password);
                 list.add(u);
                }

            }
            bf.close();
            fr.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return list;
    }
    public static boolean checkLogin(String username, String password)
    {
        List<Users> data=readFile(filename);
        for (Users users : data) {
            if(users.getUsername().equals(username) && users.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
}
