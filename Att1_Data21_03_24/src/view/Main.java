package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavalo;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);

		for (int id = 1; id <= 4; id++) {
			Thread correr = new ThreadCavalo(id, semaforo);
			correr.start();
		}

	}

}
