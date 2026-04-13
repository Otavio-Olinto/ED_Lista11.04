package controller;

import otavioolinto.fila.Fila;
import javax.swing.JOptionPane;

public class ImpressoraController {

	public ImpressoraController() {
		super();
	}
	
	public void inserirDocumento(Fila<String> fila, String documento) {
		
		fila.insert(documento);
	}
	
	public void imprimir(Fila<String> fila)throws Exception {
		
		if(fila.isEmpty()) throw new Exception("Não há documentos para imprimir");
		
		int tempo = (int) Math.random()*1001+1000;
		
		String[] doc = fila.remove().split(";");
		
		JOptionPane.showMessageDialog(null, "Imprimir?\n#PC: "+doc[0]+" - Arquivo: "+doc[1]);
		
		// pausa a execução da thread atual por um tempo específico, 
		// definido em milissegundos, sem consumir ciclos de CPU durante a espera
		Thread.sleep(tempo);
		
		JOptionPane.showMessageDialog(null, "O Arquivo: "+doc[1]+" foi impresso.");
	}

}
