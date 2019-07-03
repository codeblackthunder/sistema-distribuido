package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1- indicar o ip do cliente e a porta de execução aonde o servidor está ouvindo
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor!");

		//2-criamos um scanner do tipo system.in ou seja salvar dados digitados 
		//printStream com metodo getOutputStream para enviar dados ao servidor
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		//3-criar um loop utilizando este metodo para controlar o loop ou seja após cada envio travar o loop
		while (teclado.hasNextLine()) {
			//cada dado digitado pelo usuário vai ser printado no system abaixo.
			saida.println(teclado.nextLine());
		}
		//3-fechamento do teclado do printStream e do cliente
		saida.close();
		teclado.close();
		cliente.close();
	}
}
