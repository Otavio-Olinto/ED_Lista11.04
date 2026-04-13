package view;

import otavioolinto.fila.Fila;
import controller.ImpressoraController;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// Criando a fila de documentos
		Fila<String> fila = new Fila<>(String.class);
		
		// Instanciando os métodos da classe ImpressoraController
		ImpressoraController metodo = new ImpressoraController();
		
		// Criando o buffer de leitura
		StringBuffer buffer = new StringBuffer();
		
		int opc = 0;
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada"+
								   "\n1 - Adicionar documentos a fila de impressão"+
								   "\n2 - Imprimir"+
								   "\n3 - Sair"));
			
			switch(opc) {
				case 1:
					buffer.append(JOptionPane.showInputDialog("Digite o ID do computador:"));
					buffer.append(";");
					buffer.append(JOptionPane.showInputDialog("Digite o Nome do arquivo:"));
					String documento = buffer.toString();
					
					// Limpando o buffer
					buffer.setLength(0);
					
					metodo.inserirDocumento(fila, documento);
					break;
					
				case 2:
					try {
						
						metodo.imprimir(fila);
					}catch(Exception exc) {
						
						JOptionPane.showMessageDialog(null, exc.getMessage());
					}
					break;
				
				case 3:
					JOptionPane.showMessageDialog(null, "Fim da Aplicação");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida\nTente novamente");
					break;
			}
		}while(opc!=3);
		
		System.exit(0);
	}

}
