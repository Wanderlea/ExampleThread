package br.com.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenTime2 extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout());
	private JLabel descriptionTime = new JLabel("Name");
	private JTextField showTime = new JTextField();

	private JLabel descriptionTime2 = new JLabel("E-mail");
	private JTextField showTime2 = new JTextField();

	private JButton jButton = new JButton("Add List");
	private JButton jButton2 = new JButton("Stop");

	private ImplementationQueueThread queue = new ImplementationQueueThread();

	public ScreenTime2() {
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
		jPanel.add(showTime, gridBagConstraints);

		gridBagConstraints.gridy++;
		descriptionTime2.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descriptionTime2, gridBagConstraints);

		gridBagConstraints.gridy++;
		showTime2.setPreferredSize(new Dimension(200, 25));
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
				
				if(queue == null){
					queue = new ImplementationQueueThread();
					queue.start();
				}
				
				//simulating bulk uploads
				for (int qtd = 0; qtd < 30; qtd++) {
					ObjectQueueThread objectQueueThread = new ObjectQueueThread();
					objectQueueThread.setNome(showTime.getText());
					objectQueueThread.setEmail(showTime2.getText() + " - " + qtd);

					queue.add(objectQueueThread);
				}

			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				queue.stop();
				queue = null;

			}
		});

		queue.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true);
	}

}
