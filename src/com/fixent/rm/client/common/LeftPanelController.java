package com.fixent.rm.client.common;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import com.fixent.rm.client.controller.MaintenanceController;
import com.fixent.rm.client.controller.RentDashboardController;

public class LeftPanelController {

	LeftPanel leftPanel;

	public LeftPanelController() {

		leftPanel = new LeftPanel();
		leftPanel.getBookButton().addActionListener(new BookAction());
		leftPanel.getSubscriberButton().addActionListener(
				new SubscriberAction());
	}

	class BookAction implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			navigateAction(e);
		}

	}

	class SubscriberAction implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			navigateAction(e);
		}

	}
	
	void navigateAction(ActionEvent e) {
		


		System.out.println(leftPanel.getParent());

		for (Component component2 : leftPanel.getParent()
				.getComponents()) {

			if (component2 instanceof JScrollPane) {

				for (Component component : ((JScrollPane) component2)
						.getComponents()) {

					if (component instanceof JViewport) {

						RightPanel rightSidePanel = (RightPanel) ((JViewport) component)
								.getComponents()[0];
						rightSidePanel.removeAll();
						if (((JButton)e.getSource()).getText().equalsIgnoreCase(
								"Group/Shop")) {

							rightSidePanel
									.add(new MaintenanceController().view,
											BorderLayout.CENTER);
						} else if (((JButton)e.getSource()).getText().equalsIgnoreCase(
								"Rent")) {

							rightSidePanel
									.add(new RentDashboardController().view,
											BorderLayout.CENTER);
						}
						rightSidePanel.repaint();
						rightSidePanel.revalidate();
						rightSidePanel.setVisible(true);
					}
				}

			}
		}

	
	}

}
