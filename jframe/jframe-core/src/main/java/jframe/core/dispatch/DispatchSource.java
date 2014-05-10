/**
 * 
 */
package jframe.core.dispatch;

import jframe.core.msg.Msg;

/**
 * TODO send offer sync and aync method
 * 
 * @author dzh
 * @date Jun 18, 2013 4:22:43 PM
 */
public interface DispatchSource {

	void send(Msg<?> msg);

	void addDispatch(Dispatcher d);

	void removeDispatch(Dispatcher d);

}