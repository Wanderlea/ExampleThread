package br.com.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenTime extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout());
	private JLabel descriptionTime = new JLabel("Time Thread 1");
	private JTextField showTime = new JTextField();

	private JLabel descriptionTime2 = new JLabel("Time Thread 2");
	private JTextField showTime2 = new JTextField();

	private JButton jButton = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				showTime.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {
				showTime2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private Thread thread1Time;
	private Thread thread2Time;

	public ScreenTime() {
		setTitle("Screen Time and Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = gridBagConstraints.WEST;

		descriptionTime.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descriptionTime, gridBagConstraints);

		gridBagConstraints.gridy++;
		showTime.setPreferredSize(new Dimension(200, 25));
		showTime.setEditable(false);
		jPanel.add(showTime, gridBagConstraints);

		gridBagConstraints.gridy++;
		descriptionTime2.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descriptionTime2, gridBagConstraints);

		gridBagConstraints.gridy++;
		showTime2.setPreferredSize(new Dimension(200, 25));
		showTime2.setEditable(false);
		jPanel.add(showTime2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		gridBagConstraints.gridy++;
		jButton.setPreferredSize(new Dimension(92, 25));
		jPanel.add(jButton, gridBagConstraints);

		gridBagConstraints.gridx++;
		jButton2.setPreferredSize(new Dimension(92, 25));
		jPanel.add(jButton2, gridBagConstraints);

		// Performs button click
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				thread1Time = new Thread(thread1);
				thread1Time.start();
				
				thread2Time = new Thread(thread2);
				thread2Time.start();
				
				jButton.setEnabled(false);
				jButton2.setEnabled(true);
				
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time.stop();
				thread2Time.stop();
				
				jButton.setEnabled(true);
				jButton2.setEnabled(false);
			}
		});
		
		jButton2.setEnabled(false);

		add(jPanel, BorderLayout.WEST);
		setVisible(true);
	}

}
