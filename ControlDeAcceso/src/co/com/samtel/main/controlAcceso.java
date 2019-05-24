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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class controlAcceso extends JFrame {

	private JPanel contentPane;
	private JTextField txtRuta;
	private FileView f = new FileView();
	JFileChooser fc = new JFileChooser();
	private JTextPane txtAlert;
	private viewControlAccesoController vc = new viewControlAccesoController();
	private JComboBox cbxDesde;
	private JComboBox cbxHasta;
	private JComboBox cbxPorcentajeR;
	private JComboBox cbxAnio;
	private int year = 0;
	private int mes = 0;
	private int diaI = 0;
	private int diaF = 0;

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

					for (int i = 10; i <= 100; i = i + 10) {
						frame.cbxPorcentajeR.addItem(i);
					}

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
		setBounds(100, 100, 449, 312);
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
				}catch (NullPointerException en) {
					
				}

			}
		});

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// verifica que el FileChoose no este vacio.
					// de tenero un archivo lo copia desde la ruta de origen a la ruta de destino
					if (fc != null) {
						Boolean val = f.createDirec(fc.getSelectedFile().getAbsolutePath(),
								fc.getSelectedFile().getName());
						if (val == true) {
							String name_file = fc.getSelectedFile().getName();

							// volvemos nulo a el filechooser para que no se vuelva a cargar.
							fc = null;

							try {
								// se hace la carga a la base de datos
								Boolean resp = vc.cargarData(name_file);
								if (resp == true) {

									// enviamos un mensaje para indicar que el archivo se subio de manera correcta
									getTxtAlert().setText("El archivo se cargo de manera Exitosa");

								} else {
									// enviamos un mensaje para indicar que el archivo se subio de manera correcta
									getTxtAlert().setText("Error de archivo, verifique que es el correcto");
								}

							} catch (Exception e2) {
								getTxtAlert().setText("Error registrando en la base de datos");
							}

							// borramos el nmobre del archivo que se tomo
							txtRuta.setText("");

						} else {
							// borramos el nmobre del archivo que se tomo
							txtRuta.setText("");
							// volvemos nulo a el filechooser para que no se vuelva a cargar.
							fc = null;
							// enviamos un mensaje para indicar que el archivo fallo al subirse
							getTxtAlert().setText("Fallo al subir el archivo");
							System.out.println("el archivo no se cargo, verifica cual es el problema");
						}

					} else {
						txtRuta.setText("");
						getTxtAlert().setText("Seleccione un archivo");
					}
				} catch (NullPointerException e2) {
					System.out.println(e2);
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
		tabbedPane.setToolTipText("\r\n");
		tabbedPane.setBackground(Color.WHITE);

		JPanel pnlReportes = new JPanel();
		pnlReportes.setToolTipText("Reportes");
		tabbedPane.addTab("Reportes", null, pnlReportes, null);

		JComboBox cbxTipoReporte = new JComboBox();
		cbxTipoReporte.setModel(new DefaultComboBoxModel(new String[] { "Seleccione el tipo reporte ...", "Retardos\t",
				"Menor Horas Trabajadas", "Mayor Horas Trabajadas" }));

		JLabel lblSeleccioneElTipo = new JLabel("Tipo reporte ");

		cbxAnio = new JComboBox();
		cbxAnio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cbxAnio.removeAllItems();
				List<Integer> data = vc.findbyRequer(0, 0, 1);
				for (int i = 0; i < data.size(); i++) {
					cbxAnio.addItem(data.get(i));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				year = Integer.parseInt(String.valueOf(cbxAnio.getSelectedItem()));
				System.out.println(year);
			}
		});

		JComboBox cbxMes = new JComboBox();
		cbxMes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cbxMes.removeAllItems();
				List<Integer> data = vc.findbyRequer(year, 0, 2);
				for (int i = 0; i < data.size(); i++) {
					cbxMes.addItem(data.get(i));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				mes = Integer.parseInt(String.valueOf(cbxMes.getSelectedItem()));
				System.out.println(mes);
			}
		});
		cbxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		cbxDesde = new JComboBox();
		cbxDesde.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				diaI = Integer.parseInt(String.valueOf(cbxDesde.getSelectedItem()));
				System.out.println(diaI);
			}

			@Override
			public void focusGained(FocusEvent e) {
				cbxDesde.removeAllItems();
				cbxHasta.removeAllItems();
				List<Integer> data = vc.findbyRequer(year, mes, 3);
				for (int i = 0; i < data.size(); i++) {
					cbxDesde.addItem(data.get(i));
					cbxHasta.addItem(data.get(i));
				}
			}
		});
		cbxDesde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		cbxHasta = new JComboBox();
		cbxHasta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				diaF = Integer.parseInt(String.valueOf(cbxHasta.getSelectedItem()));
				System.out.println(diaF);
			}
		});

		cbxPorcentajeR = new JComboBox();

		JLabel lblAo = new JLabel("A\u00F1o");

		JLabel lblMes = new JLabel("Mes");

		JLabel lblDesde = new JLabel("Desde");

		JLabel lblHasta = new JLabel("Hasta");

		JLabel lblPorcentaje = new JLabel("Porcentaje Resumen");

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reporte = cbxTipoReporte.getSelectedIndex();
				
				if(year != 0 && mes != 0 && diaI != 0 && diaF != 0) {
					switch (reporte) {
					case 1:
                        
						vc.AlertaRetardos(mes,year, diaI, diaF);
						getTxtAlert().setText("Reporte generado correctamente");
						break;
					case 2:
						vc.AlertaMenorHorasLaboradas( mes,year, diaI, diaF);
						getTxtAlert().setText("Reporte generado correctamente");
						break;
					case 3:
						vc.AlertaMayorHorasLaboradas(mes,year, diaI, diaF);
						getTxtAlert().setText("Reporte generado correctamente");
						break;

					default:
						break;
					}
					
				}else {
					
					getTxtAlert().setText("Ingrese los parametros de busqueda");
				}
				
				cbxDesde.removeAllItems();
				cbxHasta.removeAllItems();
				cbxMes.removeAllItems();
				cbxAnio.removeAllItems();
				System.out.println("El reporte seleccionado es: " + cbxTipoReporte.getSelectedIndex());
				cbxTipoReporte.setSelectedIndex(0);
				mes = 0;
				year = 0;
				diaI = 0;
				diaF = 0;
				
				System.out.println("los valores son:" + " año: " + year + " mes: " + mes + " dia inicial: " + diaI
						+ " dia final " + diaF);
			}
		});

		JButton btnDescartar = new JButton("Descartar");
		btnDescartar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxDesde.removeAllItems();
				cbxHasta.removeAllItems();
				cbxMes.removeAllItems();
				cbxAnio.removeAllItems();
				System.out.println("El reporte seleccionado es: " + cbxTipoReporte.getSelectedIndex());
				cbxTipoReporte.setSelectedIndex(0);
				mes = 0;
				year = 0;
				diaI = 0;
				diaF = 0;

			}
		});
		GroupLayout gl_pnlReportes = new GroupLayout(pnlReportes);
		gl_pnlReportes.setHorizontalGroup(gl_pnlReportes.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlReportes
				.createSequentialGroup().addGap(28)
				.addGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSeleccioneElTipo, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlReportes.createSequentialGroup()
								.addGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING)
										.addComponent(cbxAnio, GroupLayout.PREFERRED_SIZE, 60,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAo, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_pnlReportes
												.createParallelGroup(Alignment.LEADING).addComponent(lblMes,
														GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbxMes, GroupLayout.PREFERRED_SIZE, 45,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 35,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbxDesde, GroupLayout.PREFERRED_SIZE, 45,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlReportes.createSequentialGroup().addGap(14)
												.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 35,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(lblPorcentaje, GroupLayout.DEFAULT_SIZE, 103,
														Short.MAX_VALUE))
										.addGroup(gl_pnlReportes.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_pnlReportes.createSequentialGroup()
																.addComponent(btnGenerar).addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(btnDescartar))
														.addGroup(gl_pnlReportes.createSequentialGroup()
																.addComponent(cbxHasta, GroupLayout.PREFERRED_SIZE, 45,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(cbxPorcentajeR,
																		GroupLayout.PREFERRED_SIZE, 84,
																		GroupLayout.PREFERRED_SIZE)))))
								.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
						.addComponent(cbxTipoReporte, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
				.addGap(42)));
		gl_pnlReportes.setVerticalGroup(gl_pnlReportes.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlReportes
				.createSequentialGroup().addContainerGap()
				.addComponent(lblSeleccioneElTipo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE).addGap(5)
				.addComponent(cbxTipoReporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnlReportes.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesde).addComponent(lblHasta).addComponent(lblMes).addComponent(lblPorcentaje))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_pnlReportes.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxAnio, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxMes, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxDesde, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxHasta, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxPorcentajeR, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(gl_pnlReportes.createParallelGroup(Alignment.BASELINE).addComponent(btnGenerar)
						.addComponent(btnDescartar))
				.addContainerGap(20, Short.MAX_VALUE)));
		pnlReportes.setLayout(gl_pnlReportes);

		txtAlert = new JTextPane();
		txtAlert.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtAlert.setEditable(false);
		txtAlert.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(
						Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
										.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 410,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
												.addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, 202,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 96,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnGuardar,
														GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
										.addComponent(txtAlert, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386,
												Short.MAX_VALUE))
										.addGap(52)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAbrir).addComponent(btnGuardar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtAlert, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(104, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
	}

	public JTextPane getTxtAlert() {
		return txtAlert;
	}

	public JComboBox getCbxDesde() {
		return cbxDesde;
	}

	public JComboBox getCbxHasta() {
		return cbxHasta;
	}

	public JComboBox getCbxPorcentajeR() {
		return cbxPorcentajeR;
	}

	public JComboBox getCbxAnio() {
		return cbxAnio;
	}
}
