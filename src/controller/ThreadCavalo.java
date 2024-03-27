package controller;

import java.util.concurrent.Semaphore;

public class ThreadCavalo extends Thread {

	private int id;
	private Semaphore semaforo;
	private static boolean crtlt = true;
	private static boolean crtlp = true;
	private static int tocha;
	private static int pedra;
	private int percorrido = 0;
	private static int porta = 1;
	private static int portaC = (int) ((Math.random() * 4) + 1);;

	public ThreadCavalo(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		caminhada();
		try {
			semaforo.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void porta() {
		if (porta == portaC) {
			System.out.println("Parabens cavaleiro " + id + " voce conseguiu!!!");
		} else {
			System.out.println("Caveleiro " + id + " morreu tentando :(");
		}
		porta += 1;

	}

	private void caminhada() {
		try {
			while (percorrido <= 2000) {
				if (percorrido >= 500 && crtlt == true) {
					tocha = id;
					crtlt = false;
					System.out.println("O cavaleiro " + id + " pegou a tocha");
				}
				if (percorrido >= 1500 && crtlp == true) {
					pedra = id;
					crtlp = false;
					System.out.println("O cavaleiro " + id + " pegou a pedra");
				}
				if (id != tocha || id != pedra) {
					percorrido += (int) (((Math.random() * 3) + 2));
					System.out.println("O cavaleiro " + id + " percorreu " + percorrido + "m.");
					sleep(50);
				} else if (id == tocha || id == pedra) {
					percorrido += (int) (((Math.random() * 3) + 2) + 2);
					System.out.println("O cavaleiro " + id + " percorreu " + percorrido + "m.");
					sleep(50);
				} else {
					percorrido += (int) (((Math.random() * 3) + 2) + 4);
					System.out.println("O cavaleiro " + id + " percorreu " + percorrido + "m.");
					sleep(50);
				}
			}
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}

	}
}