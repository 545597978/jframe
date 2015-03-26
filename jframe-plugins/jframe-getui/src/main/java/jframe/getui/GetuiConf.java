/**
 * 
 */
package jframe.getui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dzh
 * @date Sep 29, 2014 1:24:47 PM
 * @since 1.0
 */
public class GetuiConf {

	static final Logger LOG = LoggerFactory.getLogger(GetuiConf.class);

	public static String APPID;
	public static String APPKEY;
	public static String MASTER_SECRET;
	public static String HOST;

	public static String HTTP_CONN_COUNT = "100";
	public static String HTTP_CONN_TIMEOUT = "30000";

	static boolean init = false;

	public synchronized static void init(String file) throws Exception {
		if (init)
			return;

		try {
			init(new FileInputStream(file));
		} catch (Exception e) {
			throw e;
		}
		init = true;
	}

	public static final String KEY_APPID = "app.id";
	public static final String KEY_APPKEY = "app.key";
	public static final String KEY_MASTER_SECRET = "master_secret";
	public static final String KEY_HOST = "host";
	public static final String KEY_HTTP_CONN_COUNT = "http.conn.count";
	public static final String KEY_HTTP_CONN_TIMEOUT = "http.conn.timeout";

	public synchronized static void init(InputStream is) throws IOException {
		if (is == null)
			return;
		Properties props = new Properties();
		try {
			props.load(is);
			APPID = props.getProperty(KEY_APPID);
			APPKEY = props.getProperty(KEY_APPKEY);
			MASTER_SECRET = props.getProperty(KEY_MASTER_SECRET);
			HOST = props.getProperty(KEY_HOST);
			HTTP_CONN_COUNT = props.getProperty(KEY_HTTP_CONN_COUNT, "100");
			HTTP_CONN_TIMEOUT = props.getProperty(KEY_HTTP_CONN_TIMEOUT,
					"30000");
		} catch (MissingResourceException e) {
			LOG.error(e.getMessage());
		} finally {
			is.close();
		}
	}

}
