/**
 * 
 */
package path;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import junit.framework.Assert;

/**
 * @author dzh
 * @date Sep 27, 2013 4:44:14 PM
 * @since 1.0
 */
public class TestPath {

	public void testPaths() {
		String p = "/home/dzh/temp";
		Path path = Paths.get(p, "fs");
		System.out.println(path.getFileName());

		Iterator<Path> iter = path.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toFile().getAbsolutePath());
		}
		Assert.assertEquals(p, Paths.get(p).toFile().getAbsolutePath());

		String fp = "/home/dzh/temp/test.md";
		File file = new File(fp);
		System.out.println(file.getAbsolutePath());

		file = new File(p);
		System.out.println(file.getAbsolutePath());
	}

//	@Test
	public void testURL() throws MalformedURLException {
		URL url = null;
		url = new URL("file:/home/dzh/1111");
		File f = new File(url.getPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
	}

}
