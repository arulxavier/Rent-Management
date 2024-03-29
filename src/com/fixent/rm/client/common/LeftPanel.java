/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixent.rm.client.common;

/**
 *
 * @author Mathan
 */
public class LeftPanel extends javax.swing.JPanel {

    /**
     * Creates new form LeftPanel
     */
    public LeftPanel() {
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

        groupShopButton = new javax.swing.JButton();
        TenantButton = new javax.swing.JButton();
        deliveryButton = new javax.swing.JButton();
        notificationButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        groupShopButton.setBackground(new java.awt.Color(61, 86, 109));
        groupShopButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        groupShopButton.setForeground(new java.awt.Color(255, 255, 255));
        groupShopButton.setText("Group/Shop");
        groupShopButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        groupShopButton.setFocusPainted(false);

        TenantButton.setBackground(new java.awt.Color(61, 86, 109));
        TenantButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TenantButton.setForeground(new java.awt.Color(255, 255, 255));
        TenantButton.setText("Rent");
        TenantButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        TenantButton.setFocusPainted(false);
        TenantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenantButtonActionPerformed(evt);
            }
        });

        deliveryButton.setBackground(new java.awt.Color(61, 86, 109));
        deliveryButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        deliveryButton.setForeground(new java.awt.Color(255, 255, 255));
        deliveryButton.setText("--");
        deliveryButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        deliveryButton.setFocusPainted(false);

        notificationButton.setBackground(new java.awt.Color(61, 86, 109));
        notificationButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        notificationButton.setForeground(new java.awt.Color(255, 255, 255));
        notificationButton.setText("--");
        notificationButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        notificationButton.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(groupShopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TenantButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deliveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(notificationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(groupShopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TenantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(notificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TenantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenantButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenantButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TenantButton;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JButton groupShopButton;
    private javax.swing.JButton notificationButton;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JButton getBookButton() {
		return groupShopButton;
	}

	public void setBookButton(javax.swing.JButton bookButton) {
		this.groupShopButton = bookButton;
	}

	public javax.swing.JButton getDeliveryButton() {
		return deliveryButton;
	}

	public void setDeliveryButton(javax.swing.JButton deliveryButton) {
		this.deliveryButton = deliveryButton;
	}

	public javax.swing.JButton getNotificationButton() {
		return notificationButton;
	}

	public void setNotificationButton(javax.swing.JButton notificationButton) {
		this.notificationButton = notificationButton;
	}

	public javax.swing.JButton getSubscriberButton() {
		return TenantButton;
	}

	public void setSubscriberButton(javax.swing.JButton subscriberButton) {
		this.TenantButton = subscriberButton;
	}
    
}
