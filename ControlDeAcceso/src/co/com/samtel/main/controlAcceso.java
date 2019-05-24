package co.com.samtel.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.record.LbsDataSubRecord;

import co.com.samtel.util.FileView;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class controlAcceso extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private FileView f = new FileView();
	JFileChooser fc = new JFileChooser();
	private JTextPane txtAlert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlAcceso frame = new controlAcceso();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public controlAcceso() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setEnabled(false);
		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					fc = f.openfolders();
					txtRuta.setText(fc.getSelectedFile().getName());
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
   
				if(fc != null ) {
					Boolean val = f.createDirec(fc.getSelectedFile().getAbsolutePath(), fc.getSelectedFile().getName());
					if (val == true) {
						getTxtAlert().setText("El archivo se cargo de manera Exitosa");
						fc = null;
						System.out.println("El archivo se cargo de manera exitosa");
						txtRuta.setText("");
					} else {
						getTxtAlert().setText("Fallo al subir el archivo");
						fc = null;
						txtRuta.setText("");
						System.out.println("el archivo no se cargo, verifica cual es el problema");
					}
					
				}else {
					txtRuta.setText("");
					getTxtAlert().setText("Seleccione un archivo");
				}
			

			}
		});

		txtRuta = new JTextField();
		txtRuta.setBackground(Color.WHITE);
		txtRuta.setEditable(false);
		txtRuta.setColumns(10);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setToolTipText("");
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);

		txtAlert = new JTextPane();
		txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtAlert.setEditable(false);
		txtAlert.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtAlert, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbrir)
						.addComponent(btnGuardar)
						.addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAlert, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}

	public JTextPane getTxtAlert() {
		return txtAlert;
	}
}
