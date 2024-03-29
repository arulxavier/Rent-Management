/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fixent.rm.client.view;

/**
 *
 * @author skumar3
 */
public class RentView extends javax.swing.JPanel {

    /**
     * Creates new form RentView
     */
    public RentView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        shopNumberComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        shopNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        leaseStartDatePicker = new com.fixent.component.datepicker.ADatePicker();
        jLabel4 = new javax.swing.JLabel();
        noOfYearComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        leaseEndDatePicker = new com.fixent.component.datepicker.ADatePicker();
        jLabel6 = new javax.swing.JLabel();
        paymentOptionComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        rentPerSqrtTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dueAmountTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentScheduleTable = new javax.swing.JTable();
        generateButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Shop Number");

        shopNumberComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        shopNumberComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Shop Name");

        shopNameTextField.setColumns(15);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Lease Start");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("No of Year");

        noOfYearComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        noOfYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Lease End");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Payment Option");

        paymentOptionComboBox.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        paymentOptionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Rent Per Sqrt");

        rentPerSqrtTextField.setColumns(15);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Due Amount");

        dueAmountTextField.setColumns(15);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Shop Details");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText("Payment Schedule");

        paymentScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(paymentScheduleTable);

        generateButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        generateButton.setText("Generate");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setText("Contact Details");

        contactTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(contactTable);

        saveButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        saveButton.setText("Save");

        cancelButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");

        addButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        addButton.setText("Add");

        deleteButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        deleteButton.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11)
                        .addComponent(jLabel9)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(leaseStartDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(leaseEndDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(71, 71, 71))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(shopNumberComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(44, 44, 44)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rentPerSqrtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(noOfYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(shopNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dueAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentOptionComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(generateButton))
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(shopNumberComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(shopNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(leaseStartDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(noOfYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(leaseEndDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(paymentOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rentPerSqrtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(dueAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10))
                    .addComponent(generateButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable contactTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dueAmountTextField;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.fixent.component.datepicker.ADatePicker leaseEndDatePicker;
    private com.fixent.component.datepicker.ADatePicker leaseStartDatePicker;
    private javax.swing.JComboBox noOfYearComboBox;
    private javax.swing.JComboBox paymentOptionComboBox;
    private javax.swing.JTable paymentScheduleTable;
    private javax.swing.JTextField rentPerSqrtTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField shopNameTextField;
    private javax.swing.JComboBox shopNumberComboBox1;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(javax.swing.JButton addButton) {
		this.addButton = addButton;
	}

	public javax.swing.JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(javax.swing.JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public javax.swing.JTable getContactTable() {
		return contactTable;
	}

	public void setContactTable(javax.swing.JTable contactTable) {
		this.contactTable = contactTable;
	}

	public javax.swing.JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(javax.swing.JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public javax.swing.JTextField getDueAmountTextField() {
		return dueAmountTextField;
	}

	public void setDueAmountTextField(javax.swing.JTextField dueAmountTextField) {
		this.dueAmountTextField = dueAmountTextField;
	}

	public javax.swing.JButton getGenerateButton() {
		return generateButton;
	}

	public void setGenerateButton(javax.swing.JButton generateButton) {
		this.generateButton = generateButton;
	}

	public com.fixent.component.datepicker.ADatePicker getLeaseEndDatePicker() {
		return leaseEndDatePicker;
	}

	public void setLeaseEndDatePicker(
			com.fixent.component.datepicker.ADatePicker leaseEndDatePicker) {
		this.leaseEndDatePicker = leaseEndDatePicker;
	}

	public com.fixent.component.datepicker.ADatePicker getLeaseStartDatePicker() {
		return leaseStartDatePicker;
	}

	public void setLeaseStartDatePicker(
			com.fixent.component.datepicker.ADatePicker leaseStartDatePicker) {
		this.leaseStartDatePicker = leaseStartDatePicker;
	}

	public javax.swing.JComboBox getNoOfYearComboBox() {
		return noOfYearComboBox;
	}

	public void setNoOfYearComboBox(javax.swing.JComboBox noOfYearComboBox) {
		this.noOfYearComboBox = noOfYearComboBox;
	}

	public javax.swing.JComboBox getPaymentOptionComboBox() {
		return paymentOptionComboBox;
	}

	public void setPaymentOptionComboBox(javax.swing.JComboBox paymentOptionComboBox) {
		this.paymentOptionComboBox = paymentOptionComboBox;
	}

	public javax.swing.JTable getPaymentScheduleTable() {
		return paymentScheduleTable;
	}

	public void setPaymentScheduleTable(javax.swing.JTable paymentScheduleTable) {
		this.paymentScheduleTable = paymentScheduleTable;
	}

	public javax.swing.JTextField getRentPerSqrtTextField() {
		return rentPerSqrtTextField;
	}

	public void setRentPerSqrtTextField(javax.swing.JTextField rentPerSqrtTextField) {
		this.rentPerSqrtTextField = rentPerSqrtTextField;
	}

	public javax.swing.JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(javax.swing.JButton saveButton) {
		this.saveButton = saveButton;
	}

	public javax.swing.JTextField getShopNameTextField() {
		return shopNameTextField;
	}

	public void setShopNameTextField(javax.swing.JTextField shopNameTextField) {
		this.shopNameTextField = shopNameTextField;
	}

	public javax.swing.JComboBox getShopNumberComboBox1() {
		return shopNumberComboBox1;
	}

	public void setShopNumberComboBox1(javax.swing.JComboBox shopNumberComboBox1) {
		this.shopNumberComboBox1 = shopNumberComboBox1;
	}
    
    
}
