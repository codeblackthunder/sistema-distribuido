package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	/* [CLIENTE]
	 * 1-criar o socket com ip da maquina e a porta que o servidor está ouvindo
	 * 1.1-colocar o socket envolvido pelo try catch
	 * 2 criar o que queremos recuperar(input) ou enviar(output)
	 * 2.1 neste caso queremos enviar,sendo assim precisamos criar o metodo output
	 * 2.2 colocamos como parametro o metodo respectivo do output
	 * 3 Criamos um scanner para popular os dados digitados no console
	 * 4 criamos um loop para ouvir
	 * 4.1 populamos as mensagens com nextLine
	 * 4.2 enviamos mensagem com output.writeObject(msg);
	 * 4.3 damos um output.flush();
	 * 
	 * */
	
	public static void main(String[] args) {
	try {
		Socket socket = new Socket("localhost",6500);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		Scanner e = new Scanner(System.in);
		
		while(true) {
			System.out.println("Prezado cliente digite sua mensagem>>>");
			String msg = e.nextLine();
			out.writeObject(msg);
			out.flush();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}

}
