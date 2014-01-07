/**
 * 
 */
package jframe.core.plugin.loader;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * <li>One PluginCase corresponds to One plug-in jar.</li>
 * <li>PluginCase record meta-data about plugin</li>
 * </p>
 * 
 * @author dzh
 * @date Sep 26, 2013 6:01:23 PM
 * @since 1.0
 */
public class PluginCase {

	public static final String LIB = "lib";
	public static final String DLL = "dll";
	public static final String INF = "META-INF";
	public static final String P_PLUGIN_CLASS = "Plugin-Class";
	public static final String P_PLUGIN_NAME = "Plugin-Name";
	public static final String P_PLUGIN_LIB = "Plugin-Lib";
	public static final String P_PLUGIN_DLL = "Plugin-Dll";

	private String pluginClass;

	private String pluginName;

	private int pluginID;

	private List<String> pluginDll = Collections.emptyList();

	private List<String> pluginLib = Collections.emptyList();

	private String jarPath;

	private String cachePath;

	public String getPluginClass() {
		return pluginClass;
	}

	public void setPluginClass(String pluginClass) {
		this.pluginClass = pluginClass;
	}

	public String getPluginName() {
		return pluginName;
	}

	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}

	public int getPluginID() {
		return pluginID;
	}

	public void setPluginID(int pluginID) {
		this.pluginID = pluginID;
	}

	public List<String> getPluginDll() {
		return pluginDll;
	}

	public void setPluginDll(List<String> pluginDll) {
		this.pluginDll = pluginDll;
	}

	public List<String> getPluginLib() {
		return pluginLib;
	}

	public void setPluginLib(List<String> pluginLib) {
		this.pluginLib = pluginLib;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	public String getCachePath() {
		return cachePath;
	}

	public void setCachePath(String cachePath) {
		this.cachePath = cachePath;
	}

	public String getCacheLibPath() {
		return this.cachePath + File.separator + LIB;
	}

	public String getCacheDllPath() {
		return this.cachePath + File.separator + DLL;
	}

	public String toString() {
		return "PluginCase: " + "PluginName-" + getPluginName() + ", JarPath-"
				+ getJarPath();
	}

}
