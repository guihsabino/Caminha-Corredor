package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	private int numeroPessoa;
	private Semaphore semaforo;

	public ThreadPessoa (int numeroPessoa, Semaphore semaforo) {
		this.numeroPessoa = numeroPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	public void abrirPorta() {
		System.out.println("O corredor " + numeroPessoa + " abriu a porta.");
		cruzouPorta();
		fechouPorta();
	}

	public void cruzouPorta() {
		System.out.println("O corredor " + numeroPessoa + " cruzou a porta.");
		int tempoCruzamento = (int) ((Math.random() + 6000) * 4000);
		try {
			Thread.sleep(tempoCruzamento);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void fechouPorta() {
		System.out.println("A pessoa " + numeroPessoa + " fechou a porta.");
	}

}
