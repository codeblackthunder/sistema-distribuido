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
        System.out.println("Nova conexão com o cliente " +     
            cliente.getInetAddress().getHostAddress()
        );

        //3-passo criamos o s que ler os dados digitados pelo cliente
        Scanner s = new Scanner(cliente.getInputStream());
        
        //4 passo criamos um while, enquanto não há um dado digitado pelo cliente não
        //avança evitando disparo do looping infinito,resumidamente serve para controlar o looping infinito
        while (s.hasNextLine()) { 
        	
        	//le o arquivo até uma quebra de linha (ENTER)
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
	TCP = Protocolo que cria fluxo(canal) entre servidor e cliente aonde se passa as informações.
	Garanti que não se perca informações no caminho entre servidor e cliente
	é necessário que esteja os dois conectados para ter a troca de informações
	
	================================================================================================
	Porta = é caracterizada pela a execução de um programa ou seja todo programa que está sendo executado
	está utilizando uma porta ou mais.é necessário definir uma porta para que nossa aplicação cliente
	e servidor possam se comunicar. As portas podem varia de 0 a 65535.
	
	
	 O OutputStream é usado para enviar dados do cliente ao servidor, enquanto o InputStream é usado para 
	 ler os dados que chegaram no servidor.
	
	Será que ao solicitar uma porta que está em uso criaria algum erro ?
	depende da implementação,é possivel contornar o problema da porta statica utilizando sockets com
	multithreads que ao ver que tem um cliente utilizando uma porta pré definida é relocado por uma porta
	disponivel
	
	
	Checklist implementação servidor simples
	-> Criar a porta em que o servidor ficará ouvindo a execução de um cliente(programa)
	-> Utilizar o método acept para indicar que um cliente foi encontrado
	-> utilizar o scanner para popular os dados que são enviados para o cliente.
	-> criar um loop que ficará ouvindo o cliente digitar os dados
	-> Fechar scanner,servidor e socket
	codigo abaixo seguindo todos checklist
	
	
	
	
     =================================*/
	
	
	
	
	
	
	
	
	