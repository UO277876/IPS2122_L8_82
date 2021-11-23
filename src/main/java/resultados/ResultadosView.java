package resultados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ResultadosView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnAbrirArchivos;
	private JButton btnProcesar;
	private JTextArea textArea;
	
	private DefaultListModel modelListFiles = null;
	
	private JFileChooser selector = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ResultadosView dialog = new ResultadosView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ResultadosView() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setBounds(100, 100, 450, 300);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getBtnAbrirArchivos());
			panel.add(getBtnProcesar());
			panel.add(getTextArea());
		}
		return panel;
	}
	private JButton getBtnAbrirArchivos() {
		if (btnAbrirArchivos == null) {
			btnAbrirArchivos = new JButton("Abrir archivos");
			btnAbrirArchivos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Integer response = getSelector().showOpenDialog(rootPane);
					if (response == JFileChooser.APPROVE_OPTION) {
						for (File f : getSelector().getSelectedFiles()) {
							modelListFiles.addElement(f);
						}
					}
				}
			});
			btnAbrirArchivos.setEnabled(true);
			btnAbrirArchivos.setHorizontalAlignment(SwingConstants.CENTER);
			btnAbrirArchivos.setForeground(Color.WHITE);
			btnAbrirArchivos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAbrirArchivos.setBackground(Color.BLUE);
			btnAbrirArchivos.setBounds(192, 233, 111, 21);
		}
		return btnAbrirArchivos;
	}
	private JButton getBtnProcesar() {
		if (btnProcesar == null) {
			btnProcesar = new JButton("Procesar");
			btnProcesar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnProcesar.setBackground(new Color(34, 139, 34));
			btnProcesar.setBounds(315, 233, 85, 21);
		}
		return btnProcesar;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(32, 29, 368, 174);
		}
		return textArea;
	}
	
	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			selector.setFileFilter(new FileNameExtensionFilter("Mp3 Files", "mp3"));
			selector.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		}
		return selector;
	}
}
