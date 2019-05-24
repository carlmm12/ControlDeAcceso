package co.com.samtel.main

import java.awt.BorderLayout
import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.border.EmptyBorder
import javax.swing.JDesktopPane
import javax.swing.JTextField
import javax.swing.GroupLayout
import javax.swing.GroupLayout.Alignment
import javax.swing.JLabel
import javax.swing.JButton
import javax.swing.LayoutStyle.ComponentPlacement
import javax.swing.JMenuBar
import javax.swing.JTabbedPane

class controlAcceso extends JFrame {
	JPanel contentPane
	JTextField textField

	/** 
	 * Launch the application.
	 */
	def static void main(String[] args) {
		EventQueue.invokeLater([
			try {
				var controlAcceso frame = new controlAcceso()
				frame.setVisible(true)
			} catch (Exception e) {
				e.printStackTrace()
			}
		])
	}

	/** 
	 * Create the frame.
	 */
	new() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		setBounds(100, 100, 476, 313)
		contentPane = new JPanel()
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5))
		contentPane.setLayout(new BorderLayout(0, 0))
		setContentPane(contentPane)
		var JPanel panel = new JPanel()
		panel.setEnabled(false)
		contentPane.add(panel, BorderLayout.CENTER)
		textField = new JTextField()
		textField.setColumns(10)
		var JButton btnNewButton = new JButton("New button")
		var JButton btnNewButton_1 = new JButton("New button")
		var JPanel panel_1 = new JPanel()
		var GroupLayout gl_panel = new GroupLayout(panel)
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup().addGap(28).addComponent(textField, GroupLayout.PREFERRED_SIZE, 225,
					GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
					btnNewButton).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1).
					addContainerGap(15, Short.MAX_VALUE)).addComponent(panel_1, Alignment.LEADING,
				GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap().addGroup(
					gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(textField, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnNewButton).addComponent(
						btnNewButton_1)).addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
					Short.MAX_VALUE).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 224,
					GroupLayout.PREFERRED_SIZE)))
		var JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP)
		var GroupLayout gl_panel_1 = new GroupLayout(panel_1)
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 462,
				Short.MAX_VALUE))
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
		var JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP)
		tabbedPane.addTab("New tab", null, tabbedPane_1, null)
		var JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP)
		tabbedPane.addTab("New tab", null, tabbedPane_2, null)
		panel_1.setLayout(gl_panel_1)
		panel.setLayout(gl_panel)
	}
}
