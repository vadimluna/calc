package propina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class calculadorapropina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ventanaImporteFactura;
	private JTextField ventanaPropina;
	private JTextField ventanaImporteTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadorapropina frame = new calculadorapropina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculadorapropina() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/Jonay/Desktop/png-transparent-computer-icons-currency-trade-currency-converter-text-trademark-service-thumbnail.png"));

		setTitle("CALCULADORA PROPINA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel etiquetaImporteFactura = new JLabel("Importe Factura:");
		etiquetaImporteFactura.setBounds(137, 6, 113, 41);
		contentPane.add(etiquetaImporteFactura);
		
		ventanaImporteFactura = new JTextField();
		ventanaImporteFactura.setText("Ingrese Importe...");
		ventanaImporteFactura.setHorizontalAlignment(SwingConstants.CENTER);
		ventanaImporteFactura.setForeground(new Color(254, 255, 255));
		ventanaImporteFactura.setBackground(new Color(0, 0, 0));
		ventanaImporteFactura.setBounds(67, 49, 253, 48);
		contentPane.add(ventanaImporteFactura);
		ventanaImporteFactura.setColumns(10);
		
		JLabel etiquetaPropinaPorcentaje = new JLabel("PROPINA %:");
		etiquetaPropinaPorcentaje.setBounds(155, 109, 78, 31);
		contentPane.add(etiquetaPropinaPorcentaje);
		
		JComboBox desplegableDescuento = new JComboBox<String>();
		desplegableDescuento.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione un Porcentaje", "3", "10", "15", "20"}));
		desplegableDescuento.setToolTipText("10%");
		desplegableDescuento.setMaximumRowCount(5);
		desplegableDescuento.setBounds(67, 148, 253, 21);
		contentPane.add(desplegableDescuento);
		
		JLabel lblNewLabel = new JLabel("PROPINA:");
		lblNewLabel.setBounds(16, 219, 67, 31);
		contentPane.add(lblNewLabel);
		
		JLabel etiquetaImporteTotal = new JLabel("IMPORTE TOTAL:");
		etiquetaImporteTotal.setBounds(224, 219, 113, 31);
		contentPane.add(etiquetaImporteTotal);
		
		ventanaPropina = new JTextField();
		ventanaPropina.setHorizontalAlignment(SwingConstants.RIGHT);
		ventanaPropina.setForeground(new Color(254, 255, 255));
		ventanaPropina.setBackground(new Color(0, 0, 0));
		ventanaPropina.setBounds(16, 262, 140, 41);
		contentPane.add(ventanaPropina);
		ventanaPropina.setColumns(10);
		
		ventanaImporteTotal = new JTextField();
		ventanaImporteTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		ventanaImporteTotal.setForeground(new Color(254, 255, 255));
		ventanaImporteTotal.setBackground(new Color(0, 0, 0));
		ventanaImporteTotal.setColumns(10);
		ventanaImporteTotal.setBounds(222, 262, 140, 41);
		contentPane.add(ventanaImporteTotal);
		
		JButton botonReinicio = new JButton("REINICIO");
		botonReinicio.setBounds(135, 352, 117, 41);
		contentPane.add(botonReinicio);
		
		botonReinicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaImporteFactura.setText("");
				ventanaPropina.setText("");
				ventanaImporteTotal.setText("");
				
				
			}
		});
		
		desplegableDescuento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//funcion del objeto Combobox para devolver el elemento seleccionado.
				desplegableDescuento.getSelectedItem().toString();
				String porcentajeSeleccionado = desplegableDescuento.getSelectedItem().toString();
				
				
				double importeFactura;
				String importeFacturaTexto=ventanaImporteFactura.getText();
				
				//
				if (importeFacturaTexto.matches("\\d+") && porcentajeSeleccionado.matches("\\d+")) {
					
					int porcentaje=Integer.parseInt(porcentajeSeleccionado);
					
					importeFactura = Double.parseDouble(importeFacturaTexto);
					
					double propina;
					propina= calcularPropina(importeFactura, porcentaje);
					ventanaPropina.setText(Double.toString(propina) + " €");
					
					double importeTotal;
					importeTotal= (importeFactura + propina);
					ventanaImporteTotal.setText(Double.toString(importeTotal) + " €");
					
				} else {
					ventanaPropina.setText("Error");
					ventanaImporteTotal.setText("Error");
				}
				
				
				
				
			}
			
		});
		
		
		

	
	}
	
	public double calcularPropina (double importe, int porcentaje) {
		return (importe * porcentaje) / 100;
	}
}
