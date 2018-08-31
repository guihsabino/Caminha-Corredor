package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {

	public static Semaphore semaforo;

	public static void main(String[] args) {

		int totalPessoas = 4;
		int totalCorredores = 4;

		semaforo = new Semaphore(totalCorredores);
		for (int i = 0; i < totalPessoas; i++);
		
		Thread corredores = new ThreadPessoa(i, semaforo);
		corredores.start();

	}

}
