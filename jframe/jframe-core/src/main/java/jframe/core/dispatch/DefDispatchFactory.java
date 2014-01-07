/**
 * 
 */
package jframe.core.dispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * delegate管理管理工厂
 * 
 * @author dzh
 * @date Jun 20, 2013 9:47:12 AM
 */
public class DefDispatchFactory implements DispatchFactory {

	private final Object _lock = new Object();

	private List<Dispatcher> _dList = new ArrayList<Dispatcher>(2);

	private DefDispatchFactory() {

	}

	public static final DispatchFactory newInstance() {
		return new DefDispatchFactory();
	}

	public Dispatcher findDispatcher(String dispatcherID) {
		List<Dispatcher> list = _dList;
		Dispatcher dl = null;
		synchronized (_lock) {
			for (Dispatcher d : list) {
				if (d.getID().equals(dispatcherID)) {
					dl = d;
					break;
				}
			}
		}
		return dl;
	}

	public Dispatcher createDispatcher(String dispatcherID) {
		Dispatcher d = DefDispatcher.newDelegate(dispatcherID);
		d.start();
		synchronized (_lock) {
			_dList.add(d);
		}
		return d;
	}

	/**
	 * if dispatcherID==Null, close all delegates
	 */
	public void removeDispacher(String dispatcherID) {
		List<Dispatcher> list = _dList;
		if (dispatcherID == null) {
			synchronized (_lock) {
				for (Dispatcher d : list) {
					d.close();
				}
			}
			list.clear();
		} else {
			synchronized (_lock) {
				Dispatcher d = findDispatcher(dispatcherID);
				if (d != null) {
					d.close();
					list.remove(d);
				}
			}
		}
	}

}
