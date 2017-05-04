package com.github.mobiletest.utils;

import java.util.List;

import com.github.mobiletest.devices.AndroidDevice;
import com.github.mobiletest.devices.DeviceConfiguration;

/**
 *
 * @author Ray_Zhou
 */
public class ChooseDevice extends javax.swing.JFrame {

	private AndroidDevice device;
	
	public AndroidDevice waitForSelectedDevice()
	{
		while(device == null)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return device;
	}
	
	/**
	 * Creates new form ChooseDevice
	 */
	public ChooseDevice() {
		try 
		{
			this.devices = new DeviceConfiguration().getDivces();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		initComponents();
	}

	private void initDeviceList() 
	{
		try 
		{
			for(AndroidDevice item : devices)
			{
				this.deviceList.addItem(item.getDeviceName() + " - " + item.getDeviceID());
			}
		} 
		catch (Exception e) {
			e.printStackTrace();

			System.out.println("ERROR: Fail to read devices data.");
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		deviceList = new javax.swing.JComboBox<>();
		jLabel1 = new javax.swing.JLabel();
		selectButton = new javax.swing.JButton();
		skipButton = new javax.swing.JButton();
		quitButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Choose Device");

		jLabel1.setText("Select Device:");

		initDeviceList();
		
		selectButton.setText("Select");
		selectButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				selectButtonMouseClicked(evt);
			}
		});

		skipButton.setVisible(false);
		skipButton.setText("Skip");
		skipButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				skipButtonMouseClicked(evt);
			}
		});

		quitButton.setText("Quit");
		quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				quitButtonMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(deviceList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jLabel1)
										.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(84, 84, 84)
						.addComponent(selectButton)
						.addGap(18, 18, 18)
						.addComponent(skipButton)
						.addGap(18, 18, 18)
						.addComponent(quitButton)
						.addContainerGap(101, Short.MAX_VALUE))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(33, 33, 33)
						.addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(deviceList, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(selectButton)
								.addComponent(skipButton)
								.addComponent(quitButton))
						.addGap(26, 26, 26))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				);

		pack();
	}// </editor-fold>                        

	private void quitButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
		System.exit(0);
	}                                       

	private void selectButtonMouseClicked(java.awt.event.MouseEvent evt) {  
		String deviceInfo = deviceList.getSelectedItem().toString();
		for(AndroidDevice device : devices)
		{
			if(deviceInfo.contains(device.getDeviceID()))
			{
				this.device = device;
				this.setVisible(false);
				break;
			}
		}
	}                                         

	private void skipButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
//		TestManagerUI.launch();
//		this.setVisible(false);
	}                                       


	private List<AndroidDevice> devices;
	
	// Variables declaration - do not modify                     
	private javax.swing.JComboBox<String> deviceList;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton quitButton;
	private javax.swing.JButton selectButton;
	private javax.swing.JButton skipButton;
	// End of variables declaration                   
}
