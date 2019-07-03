package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException {
    	//1-passo criando escuta do servidor aguardando cliente
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        //2- passo cliente conectou no nosso servidor
        Socket cliente = servidor.accept();
        System.out.println("Nova conex�o com o cliente " +     
            cliente.getInetAddress().getHostAddress()
        );

        //3-passo criamos o s que ler os dados digitados pelo cliente
        Scanner s = new Scanner(cliente.getInputStream());
        
        //4 passo criamos um while, enquanto n�o h� um dado digitado pelo cliente n�o
        //avan�a evitando disparo do looping infinito,resumidamente serve para controlar o looping infinito
        while (s.hasNextLine()) { 
        	
        	//le o arquivo at� uma quebra de linha (ENTER)
            System.out.println(s.nextLine());
        }

        // 5-passo fechamento do scanner,servidor e cliente
        s.close();
        servidor.close();
        cliente.close();
    }
}
	/*=============================== 
	Conceitos importantes:
	=============================================================================================== 
	TCP = Protocolo que cria fluxo(canal) entre servidor e cliente aonde se passa as informa��es.
	Garanti que n�o se perca informa��es no caminho entre servidor e cliente
	� necess�rio que esteja os dois conectados para ter a troca de informa��es
	
	================================================================================================
	Porta = � caracterizada pela a execu��o de um programa ou seja todo programa que est� sendo executado
	est� utilizando uma porta ou mais.� necess�rio definir uma porta para que nossa aplica��o cliente
	e servidor possam se comunicar. As portas podem varia de 0 a 65535.
	
	
	 O OutputStream � usado para enviar dados do cliente ao servidor, enquanto o InputStream � usado para 
	 ler os dados que chegaram no servidor.
	
	Ser� que ao solicitar uma porta que est� em uso criaria algum erro ?
	depende da implementa��o,� possivel contornar o problema da porta statica utilizando sockets com
	multithreads que ao ver que tem um cliente utilizando uma porta pr� definida � relocado por uma porta
	disponivel
	
	
	Checklist implementa��o servidor simples
	-> Criar a porta em que o servidor ficar� ouvindo a execu��o de um cliente(programa)
	-> Utilizar o m�todo acept para indicar que um cliente foi encontrado
	-> utilizar o scanner para popular os dados que s�o enviados para o cliente.
	-> criar um loop que ficar� ouvindo o cliente digitar os dados
	-> Fechar scanner,servidor e socket
	codigo abaixo seguindo todos checklist
	
	
	
	
     =================================*/
	
	
	
	
	
	
	
	
	