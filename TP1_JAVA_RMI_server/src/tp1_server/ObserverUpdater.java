package tp1_server;

import java.util.ArrayList;

import tp1_common.IObserver;

public class ObserverUpdater {
	private static final ArrayList<IObserver> observerList = new ArrayList<>();
	
	public static synchronized void addIObserver(IObserver observer) {
		observerList.add(observer);
	}
	
	public static synchronized void update(Object o) {
		if (CabinetImpl.cabinet.size() == 2 || CabinetImpl.cabinet.size() == 4) {
			for (IObserver observer : observerList) {
				System.out.println("test");
				try {
					observer.update(o);
				} catch (Exception e) {
	                System.err.println("observer disconnected, unsubscribing...");
	                observerList.remove(observer);
	            }
			}
		}
	}
}
