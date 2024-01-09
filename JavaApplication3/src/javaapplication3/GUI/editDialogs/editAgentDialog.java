/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.editDialogs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javaapplication3.GUI.panels.AgentPanel;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;
import javaapplication3.models.agentSubClass.Fältagent;
import javaapplication3.models.agentSubClass.KontorsChef;
import javaapplication3.models.agentSubClass.Områdeschef;
import javaapplication3.utils.ObjectManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author vilso
 */
public class editAgentDialog extends javax.swing.JDialog {
    
    private AgentPanel Parent;
    private Agent activeAgent;

    /**
     * Creates new form editAgentDialog
     */
    public editAgentDialog(java.awt.Frame parent, AgentPanel home, boolean modal, Agent agent) throws InfException {
        super(parent, modal);
        initComponents();
        this.Parent = home;
        activeAgent = agent;
        ObjectManager.Agents.LoadList();
        dynamiOfficeLabel.setVisible(false);
        dynamicControlLabel.setVisible(false);
        controlComboBox.setVisible(false);
        officeTextField.setVisible(false);
        idTextField.setEditable(false);
        fillInfo(agent);
        getContentPane().setBackground(new Color(51,51,51));
    }
    
    private void fillInfo(Agent agent) {
        fillComboBox();
        fillControlComboBox();
        nameTextField.setText(agent.getName());
        phoneTextField.setText(agent.getTelephone());
        idTextField.setText(Integer.toString(agent.getId()));
        areaComboBox.setSelectedItem(agent.getArea().getId()+": "+agent.getArea().getName());
        agentTypeComboBox.setSelectedItem(agent.getClass().getSimpleName());
        adminTypeComboBox.setSelectedItem(agent.getAdminString());
        fillAgentTypes(agent);
    }
    
    private void fillComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj område:");
        for (HashMap.Entry<Integer, Area> entry : ObjectManager.Areas.areaList.entrySet()) {
            int key = entry.getKey();
            String name = entry.getValue().getName(); // Assuming YourObjectClass has a getName() method
            dcbm.addElement(key + ": " + name);
            
            areaComboBox.setModel(dcbm);
        }
    }
    
    private void fillAgentTypes(Agent agent){
        if(agent instanceof Fältagent){
            agentTypeComboBox.setSelectedItem(agent.getClass().getSimpleName());
        }else if(agent instanceof KontorsChef){
            KontorsChef k = (KontorsChef) agent;
            agentTypeComboBox.setSelectedItem("Kontorschef");
            officeTextField.setVisible(true);
            dynamiOfficeLabel.setVisible(true);
            officeTextField.setText(k.getOfficeName());
        }else if(agent instanceof Områdeschef){
            Områdeschef o = (Områdeschef) agent;
            agentTypeComboBox.setSelectedItem(agent.getClass().getSimpleName());
            dynamicControlLabel.setVisible(true);
            controlComboBox.setVisible(true);
            String i = o.getControlArea().getId() + ": " + o.getControlArea().getName();
            controlComboBox.setSelectedItem(i);
        }else{
            System.out.println("null");
        }
    }
    
    private void fillControlComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj område:");
        for (HashMap.Entry<Integer, Area> entry : ObjectManager.Areas.areaList.entrySet()) {
            int key = entry.getKey();
            String name = entry.getValue().getName(); // Assuming YourObjectClass has a getName() method
            dcbm.addElement(key + ": " + name);
            
            controlComboBox.setModel(dcbm);
        }
    }
    
    private String getUniqueValue() {
        int index = agentTypeComboBox.getSelectedIndex();

        switch (index) {
            case 2:
                return officeTextField.getText();
            case 3:
                return controlComboBox.getSelectedItem().toString().split(":")[0].trim();
            default:
                return "";
        }
    }
    
    private String boolToChar(){
        String string = adminTypeComboBox.getSelectedItem().toString();
        if(string.equals("Ja")){
            return "J";
        }
        return "N";
    }
    
    private boolean checkDynamic(){
        int index = agentTypeComboBox.getSelectedIndex();

        return switch (index) {
            case 0 -> false;
            case 2 -> !officeTextField.getText().isEmpty();
            case 3 -> controlComboBox.getSelectedIndex()>0;
            default -> true;
        };
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abortButton = new javax.swing.JButton();
        phoneTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        inputAreaLabel = new javax.swing.JLabel();
        registerAlienLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        adminTypeComboBox = new javax.swing.JComboBox<>();
        inputSpeciesLabel = new javax.swing.JLabel();
        inputNameLabel = new javax.swing.JLabel();
        controlComboBox = new javax.swing.JComboBox<>();
        agentTypeComboBox = new javax.swing.JComboBox<>();
        officeTextField = new javax.swing.JTextField();
        inputPhoneLabel = new javax.swing.JLabel();
        dynamicControlLabel = new javax.swing.JLabel();
        areaComboBox = new javax.swing.JComboBox<>();
        inputEmailLabel = new javax.swing.JLabel();
        dynamiOfficeLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        inputAgentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 650));

        abortButton.setBackground(new java.awt.Color(204, 204, 204));
        abortButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        abortButton.setForeground(new java.awt.Color(102, 102, 102));
        abortButton.setText("Avbryt");
        abortButton.setPreferredSize(new java.awt.Dimension(180, 55));
        abortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortButtonActionPerformed(evt);
            }
        });

        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTextField.setPreferredSize(new java.awt.Dimension(180, 40));
        phoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneTextFieldKeyPressed(evt);
            }
        });

        registerButton.setBackground(new java.awt.Color(204, 204, 204));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(102, 102, 102));
        registerButton.setText("Redigera");
        registerButton.setPreferredSize(new java.awt.Dimension(180, 55));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        inputAreaLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAreaLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setText("Ange utplacering:");

        registerAlienLabel.setBackground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerAlienLabel.setForeground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setText("Redigera Agent");

        idTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        adminTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj:", "Ja", "Nej" }));
        adminTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputSpeciesLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSpeciesLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setText("Ange typ av agent:");

        inputNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setText("Ange fullständigt namn:");

        controlComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        controlComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj område:", "1: Svealand", "2: Götaland", "4: Norrland" }));
        controlComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        agentTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj typ av agent:", "Fältagent", "Kontorschef", "Områdeschef" }));
        agentTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));
        agentTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agentTypeComboBoxActionPerformed(evt);
            }
        });

        officeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        officeTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        inputPhoneLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setText("Ange telefonnummer:");

        dynamicControlLabel.setBackground(new java.awt.Color(204, 204, 204));
        dynamicControlLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dynamicControlLabel.setForeground(new java.awt.Color(204, 204, 204));
        dynamicControlLabel.setText("Dynamic control");

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj område:", "1: Svealand", "2: Götaland", "3: Norrland" }));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputEmailLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputEmailLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setText("Angivet ID");

        dynamiOfficeLabel.setBackground(new java.awt.Color(204, 204, 204));
        dynamiOfficeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dynamiOfficeLabel.setForeground(new java.awt.Color(204, 204, 204));
        dynamiOfficeLabel.setText("Dynamic Office");

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inputAgentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAgentLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAgentLabel.setText("Administratör:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNameLabel)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAreaLabel)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicControlLabel)
                    .addComponent(controlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dynamiOfficeLabel)
                    .addComponent(inputPhoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAgentLabel)
                    .addComponent(adminTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSpeciesLabel)
                    .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(registerAlienLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(registerAlienLabel)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNameLabel)
                    .addComponent(inputPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAgentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputSpeciesLabel)
                    .addComponent(inputAreaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dynamicControlLabel)
                    .addComponent(dynamiOfficeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(controlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void phoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextFieldKeyPressed

        String phoneNumber = phoneTextField.getText();
        int length = phoneNumber.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                phoneTextField.setEditable(true);
            } else {
                phoneTextField.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                phoneTextField.setEditable(true);
            } else {
                phoneTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_phoneTextFieldKeyPressed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
        boolean isNameEmpty = nameTextField.getText().isEmpty();
        boolean isPhoneEmpty = phoneTextField.getText().isEmpty();

 

        if (isNameEmpty || isPhoneEmpty) {
            JOptionPane.showMessageDialog(null, "Vänligen ange information om Agenten du vill registrera med detta formulär");
        } else {
            String newAgentType = (String) agentTypeComboBox.getSelectedItem();
            String currentAgentType = activeAgent.getClass().getSimpleName();
            
            String name = nameTextField.getText();
            String telefon = phoneTextField.getText();
            Area area = ObjectManager.Areas.areaList.get(Integer.valueOf(areaComboBox.getSelectedItem().toString().split(":")[0].trim()));
            String adminType = ((String) adminTypeComboBox.getSelectedItem()).substring(0, 1);
            
            if (newAgentType.toLowerCase().equals(currentAgentType.toLowerCase())) {
                if (activeAgent instanceof Fältagent) {
                    Fältagent fAgent = (Fältagent) activeAgent;
                    Fältagent temp = new Fältagent();
                    temp.cloneObject(fAgent);
                    
                    temp.setName(name);
                    temp.setTelephone(telefon);
                    temp.setLocation(area);
                    temp.setAdmin(adminType);
                    
                    ObjectManager.updateObject(temp);

                    fAgent = temp;

                } else if (activeAgent instanceof KontorsChef) {
                    String officeName = officeTextField.getText();
                    KontorsChef fAgent = (KontorsChef) activeAgent;
                    KontorsChef temp = new KontorsChef();
                    temp.cloneObject(fAgent);
                    
                    temp.setName(name);
                    temp.setTelephone(telefon);
                    temp.setLocation(area);
                    temp.setAdmin(adminType);
                    
                    temp.setOfficeName(officeName);
                    
                    ObjectManager.updateObject(temp);

                    fAgent = temp;

                } else if (activeAgent instanceof Områdeschef) {
                    Area controlArea = ObjectManager.Areas.areaList.get(Integer.valueOf(controlComboBox.getSelectedItem().toString().split(":")[0].trim()));
                    Områdeschef fAgent = (Områdeschef) activeAgent;
                    Områdeschef temp = new Områdeschef();
                    temp.cloneObject(fAgent);
                    
                    temp.setName(name);
                    temp.setTelephone(telefon);
                    temp.setLocation(area);
                    temp.setAdmin(adminType);
                    
                    temp.setControlArea(controlArea);
                    
                    ObjectManager.updateObject(temp);

                    fAgent = temp;

                } else {
                    Agent temp = new Agent();
                    temp.cloneObject(activeAgent);
                    
                    temp.setName(name);
                    temp.setTelephone(telefon);
                    temp.setLocation(area);
                    temp.setAdmin(adminType);
                    

                    
                    ObjectManager.updateObject(temp);

                    activeAgent = temp;
                }

                
            } else {
                Agent temp = new Agent();
                temp.cloneObject(activeAgent);

                temp.setName(name);
                temp.setTelephone(telefon);
                temp.setLocation(area);
                temp.setAdmin(adminType);

                ObjectManager.updateObject(temp);
                activeAgent = temp;

                HashMap<String, String> agentMap = new HashMap<>();
                // Populate the HashMap with additional data required for the new agent type
                agentMap.put("Agent_ID", "" + activeAgent.getId());
                agentMap.put("NewAgentType", newAgentType);

                // Add specific fields based on newAgentType
                if (newAgentType.toLowerCase().equals("kontorschef")) {
                    String officeName = officeTextField.getText();
                    agentMap.put("Kontorsbeteckning", officeName);
                } else if (newAgentType.equals("Områdeschef")) {
                    String controlAreaId = controlComboBox.getSelectedItem().toString().split(":")[0].trim();
                    agentMap.put("ControlAreaId", controlAreaId);
                }

                ObjectManager.Agents.updateSubClass(agentMap, currentAgentType, newAgentType);
            }

            JOptionPane.showMessageDialog(this, "Registreringen av Agent " + activeAgent.getId() + " lyckades!");
            ObjectManager.Agents.LoadList();
            Parent.reload();
            this.dispose();
        }

    } catch (Exception e) {
        System.out.println(e);
    }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void agentTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agentTypeComboBoxActionPerformed
        if(evt.getSource() == agentTypeComboBox){
            if(agentTypeComboBox.getSelectedIndex() == 1){
                dynamicControlLabel.setVisible(false);
                dynamiOfficeLabel.setVisible(false);
                controlComboBox.setVisible(false);
                officeTextField.setVisible(false);
            }
            if(agentTypeComboBox.getSelectedIndex() == 2){
                dynamicControlLabel.setVisible(false);
                dynamiOfficeLabel.setText("Ange kontorsnamn:");
                dynamiOfficeLabel.setVisible(true);
                officeTextField.setVisible(true);
                controlComboBox.setVisible(false);
            }
            if(agentTypeComboBox.getSelectedIndex() == 3){
                dynamiOfficeLabel.setVisible(false);
                dynamicControlLabel.setText("Välj chefsområde:");
                dynamicControlLabel.setVisible(true);
                controlComboBox.setVisible(true);
                officeTextField.setVisible(false);
            }
        }
    }//GEN-LAST:event_agentTypeComboBoxActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JComboBox<String> adminTypeComboBox;
    private javax.swing.JComboBox<String> agentTypeComboBox;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JComboBox<String> controlComboBox;
    private javax.swing.JLabel dynamiOfficeLabel;
    private javax.swing.JLabel dynamicControlLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel inputAgentLabel;
    private javax.swing.JLabel inputAreaLabel;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JLabel inputPhoneLabel;
    private javax.swing.JLabel inputSpeciesLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField officeTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel registerAlienLabel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
