/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ArmorInterface;
import DAO.ArmorServer;
import DAO.ArmorServer;
import DTO.Armor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author πΈλ°©νμλλ¨πΈ
 */
public class ArmorClient extends javax.swing.JFrame {

    /**
     * Creates new form ArmorClient
     */
    ArmorInterface server;
    DefaultTableModel model;
    Armor a;
    String filename="ArmorData.txt";
    boolean findID=true;
    boolean update=true;
    boolean add=true;
    public ArmorClient() throws NotBoundException, MalformedURLException, RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Armor Manager");
        try{
        server= (ArmorInterface) Naming.lookup("rmi://127.0.0.1:8888/now");
        if(server!=null)
        {
            JOptionPane.showMessageDialog(null, "Connect Successfull.");
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
             tblArmor.getColumnModel().getColumn(2).setMinWidth(0);
             tblArmor.getColumnModel().getColumn(2).setMaxWidth(0); 
             tblArmor.getColumnModel().getColumn(3).setMinWidth(0);
             tblArmor.getColumnModel().getColumn(3).setMaxWidth(0);
                Date TimeOfCreate=new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                txtTimeOfCreate.setText(formatter.format(TimeOfCreate));
                txtTimeOfCreate.setEnabled(false);
    }
    public void loadArmor() throws RemoteException
    {
             List<Armor> data=ArmorServer.readFile(filename);
             model=(DefaultTableModel) tblArmor.getModel();
             tblArmor.getColumnModel().getColumn(2).setMinWidth(0);
             tblArmor.getColumnModel().getColumn(2).setMaxWidth(0); 
             tblArmor.getColumnModel().getColumn(3).setMinWidth(0);
             tblArmor.getColumnModel().getColumn(3).setMaxWidth(0);
               while(model.getRowCount()!=0)
        {
            model.removeRow(0);
        }
            for (Armor armor : data) {
                model.addRow(new Object[]{armor.getArmorId(),armor.getClassification(),armor.getDescription(),armor.getStatus(),
                armor.getTimeOfCreate(),armor.getDefense()});
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDetails = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        lbClass = new javax.swing.JLabel();
        lbTimeCreate = new javax.swing.JLabel();
        lbDefense = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtClassification = new javax.swing.JTextField();
        txtTimeOfCreate = new javax.swing.JTextField();
        txtDefense = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnCreate = new javax.swing.JButton();
        btnSreach = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        btnGetAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArmor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbID.setText("ArmorID");

        lbClass.setText("Classification");

        lbTimeCreate.setText("Time Of Create");

        lbDefense.setText("Defense");

        lbDescription.setText("Description");

        lbStatus.setText("Status");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnSreach.setText("Find By ArmorID");
        btnSreach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSreachActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbDetailsLayout = new javax.swing.GroupLayout(lbDetails);
        lbDetails.setLayout(lbDetailsLayout);
        lbDetailsLayout.setHorizontalGroup(
            lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription)
                    .addGroup(lbDetailsLayout.createSequentialGroup()
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnSreach))
                    .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lbDetailsLayout.createSequentialGroup()
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                            .addComponent(btnUpdate)
                            .addGap(33, 33, 33)
                            .addComponent(btnRemove))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lbDetailsLayout.createSequentialGroup()
                            .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(lbDetailsLayout.createSequentialGroup()
                                    .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTimeCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addGroup(lbDetailsLayout.createSequentialGroup()
                                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(54, 54, 54)))
                            .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                .addComponent(txtDefense, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtClassification)
                                .addComponent(txtStatus)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        lbDetailsLayout.setVerticalGroup(
            lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSreach))
                .addGap(18, 18, 18)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTimeCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbDetailsLayout.createSequentialGroup()
                        .addComponent(lbDescription)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatus))
                .addGap(33, 33, 33)
                .addGroup(lbDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove)
                    .addComponent(btnReset))
                .addGap(87, 87, 87))
        );

        lbTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 0, 255));
        lbTitle.setText("     Armor Client");

        btnGetAll.setText("Get All");
        btnGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllActionPerformed(evt);
            }
        });

        tblArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Classification", "Description", "Status", "Time Of Create", "Defense"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArmor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(btnGetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnGetAll)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllActionPerformed
        // TODO add your handling code here:
         try {
        if(server!=null)
        {
            loadArmor();
        }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGetAllActionPerformed

    private void tblArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmorMouseClicked
        // TODO add your handling code here:
         int pos=tblArmor.getSelectedRow();
         
        try {
            if(pos>=0)
       {
           String id=tblArmor.getValueAt(pos, 0).toString();
           Armor arr=server.findByArmorID(id);
           txtID.setText(""+tblArmor.getValueAt(pos, 0));
           txtID.setEnabled(false);
           txtClassification.setText(""+tblArmor.getValueAt(pos, 1));
           txtDescription.setText(""+tblArmor.getValueAt(pos, 2));
           txtStatus.setText(""+tblArmor.getValueAt(pos, 3));
           txtTimeOfCreate.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(arr.getTimeOfCreate()));
           txtTimeOfCreate.setEnabled(false);
           txtDefense.setText(""+tblArmor.getValueAt(pos, 5));
       }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblArmorMouseClicked

    private void btnSreachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSreachActionPerformed
        // TODO add your handling code here:
        try {
            if(server!=null)
            {   if(findID)
            {
            txtID.setEnabled(true);
            txtID.requestFocus();
            tblArmor.setSelectionMode(0);
            txtClassification.setEnabled(false);
            txtTimeOfCreate.setEnabled(false);
            txtDefense.setEnabled(false);
            txtDescription.setEnabled(false);
            txtStatus.setEnabled(false);
            txtID.setText("");
            txtClassification.setText("");
            txtTimeOfCreate.setText("");
            txtDefense.setText("");
            txtDescription.setText("");
            txtStatus.setText("");
            findID = false;
            }else
            {
                List<Armor> data=ArmorServer.readFile(filename);
                String id=txtID.getText();
                if(id.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "ID not null.");
                    txtID.requestFocus();
                    return;
                }
                Armor a= server.findByArmorID(id);
                if(a!=null)
                {
                txtID.setText(a.getArmorId());
                txtClassification.setText(a.getClassification());
                txtDescription.setText(a.getDescription());
                txtStatus.setText(a.getStatus());
                txtTimeOfCreate.setText(a.getTimeOfCreate().toString());
                txtDefense.setText(""+a.getDefense());
                txtID.setEnabled(false);
                txtClassification.setEnabled(true);
                txtTimeOfCreate.setEnabled(false);
                txtDefense.setEnabled(true);
                txtDescription.setEnabled(true);
                txtStatus.setEnabled(true);
                findID=true;
                }else
                {
                    JOptionPane.showMessageDialog(null, "ID is not exits.");
                    txtID.requestFocus();
                    return;
                }
            }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSreachActionPerformed
public boolean checkId(String code) {
    try {
        server = (ArmorInterface) Naming.lookup("rmi://127.0.0.1:8888/now");
            if (server.findByArmorID(code) != null) {
                 return true;
            }
    }catch (NotBoundException ex) {
            Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return false;
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        try {
             if(server!=null)
            {
                String ArmorId=txtID.getText();
                if(ArmorId.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"ID is not empty.");
                    txtID.requestFocus();
                    return;
                }else if(checkId(ArmorId))
                {
                    JOptionPane.showMessageDialog(null, "ID not except duplicate.");
                    txtID.requestFocus();
                    return;
                }else if(ArmorId.contains("@") || ArmorId.contains("#") || ArmorId.contains("$"))
                {
                    JOptionPane.showMessageDialog(null, "ID not contains @,#,$");
                    txtID.requestFocus();
                    return;
                }else if(ArmorId.length()>10)
                {
                    JOptionPane.showMessageDialog(null, "ID must be less than 10 characters.");
                    txtID.requestFocus();
                    return;
                }
                String Classification=txtClassification.getText();
                if(Classification.isEmpty() || Classification.length()>30)
                {
                    JOptionPane.showMessageDialog(null, "Classification is not null.\nClassification must less than 30 characters.");
                    txtClassification.requestFocus();
                    return;
                }
                int Defense=0;
                try {
                    Defense=Integer.parseInt(txtDefense.getText());
                if(Defense<=0)
                {
                    JOptionPane.showMessageDialog(null, "Defense must be greater than 0.");
                    txtDefense.requestFocus();
                    return;
                }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Defense must be a number.");
                    txtDefense.requestFocus();
                    return;
                }
                String Description=txtDescription.getText();
                if(Description.isEmpty() || Description.length()>300)
                {
                    JOptionPane.showMessageDialog(null, "Description is not null.\nDescription must less than 300 characters.");
                    txtDescription.requestFocus();
                    return;
                }
                String status=txtStatus.getText();
                if(status.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Status is not null.");
                    txtStatus.requestFocus();
                    return;
                }
                SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date TimeOfCreate=sd.parse(txtTimeOfCreate.getText());
                if(JOptionPane.showConfirmDialog(null, "Do you want to add new?", null, JOptionPane.YES_NO_OPTION) == 0){
                Armor ar= new Armor(ArmorId, Classification, Description, status, TimeOfCreate, Defense);
                if(server.createArmor(ar))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfull.");
                    loadArmor();
                }else
                {
                    JOptionPane.showMessageDialog(null, "Can not add");
                }
               }
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            if(server!=null)
            {
                if(update)
                {
                     txtID.setEnabled(false);
                     tblArmor.setSelectionMode(0);
                     txtClassification.setEnabled(true);
                     txtClassification.requestFocus();
                     txtTimeOfCreate.setEnabled(false);
                     Date TimeOfCreate=new Date();
                     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                     txtTimeOfCreate.setText(formatter.format(TimeOfCreate));
                     txtDefense.setEnabled(true);
                     txtDescription.setEnabled(true);
                     txtStatus.setEnabled(true);
                    update=false;
                }else
                { 
                ArmorServer service = new ArmorServer();
                List<Armor> data=ArmorServer.readFile(filename);
                int pos=service.findByid(txtID.getText());
                if(pos==-1)
                {
                    JOptionPane.showMessageDialog(null, "Can not update.");
                    return;
                }
                String newClassification=txtClassification.getText();
                if(newClassification.isEmpty() || newClassification.length()>30)
                {
                    JOptionPane.showMessageDialog(null, "Classification is not null.\nClassification must less than 30 characters.");
                    txtClassification.requestFocus();
                    return;
                }
                int newDefense=0;
                try {
                    newDefense=Integer.parseInt(txtDefense.getText());
                if(newDefense<=0)
                {
                    JOptionPane.showMessageDialog(null, "Defense must be greater than 0.");
                    txtDefense.requestFocus();
                    return;
                }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"Defense must be a number.");
                     txtDefense.requestFocus();
                    return;
                }
                String newDescription=txtDescription.getText();
                if(newDescription.isEmpty() || newDescription.length()>300)
                {
                    JOptionPane.showMessageDialog(null, "Description is not null.\nDescription must less than 300 characters.");
                    txtDescription.requestFocus();
                    return;
                }
                String newstatus=txtStatus.getText();
                if(newstatus.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Status is not null.");
                    txtStatus.requestFocus();
                    return;
                }
                SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date newTimeOfCreate=new Date();
                String newTime=sd.format(newTimeOfCreate);
                 if (JOptionPane.showConfirmDialog(null, "Do you want to update?", null, JOptionPane.YES_NO_OPTION) == 0) {   
                data.get(pos).setClassification(newClassification);
                data.get(pos).setDefense(newDefense);
                data.get(pos).setTimeOfCreate(sd.parse(newTime));
                data.get(pos).setDescription(newDescription);
                data.get(pos).setStatus(newstatus);
                 ArmorServer.writeFile(filename, data);
                 JOptionPane.showMessageDialog(null, "Update successfull");
                 update=true;
                  loadArmor();
                }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        try {
            if(server!=null)
            {
                if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", null, JOptionPane.YES_NO_OPTION) == 0) {   
                int pos=tblArmor.getSelectedRow();
                String id=(String)tblArmor.getValueAt(pos, 0);
                if(server.removeArmor(id))
                {
                    JOptionPane.showMessageDialog(null, "Delete Successfull.");
                    loadArmor();
                }
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        try {
            if(server!=null)
            {
                txtID.setEnabled(true);
                txtClassification.setEnabled(true);
                txtTimeOfCreate.setEnabled(false);
                txtDefense.setEnabled(true);
                txtDescription.setEnabled(true);
                txtStatus.setEnabled(true);
                txtID.setText("");
                txtID.requestFocus();
                txtClassification.setText("");
                txtDescription.setText("");
                txtStatus.setText("");
                txtDefense.setText("");
                Date TimeOfCreate=new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                txtTimeOfCreate.setText(formatter.format(TimeOfCreate));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArmorClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ArmorClient().setVisible(true);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(ArmorClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSreach;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbClass;
    private javax.swing.JLabel lbDefense;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JPanel lbDetails;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTimeCreate;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTable tblArmor;
    private javax.swing.JTextField txtClassification;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTimeOfCreate;
    // End of variables declaration//GEN-END:variables
}
