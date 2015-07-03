package file;

import java.io.File;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class FileUtilsTest {
	public static void main(String[] args) throws Exception {
		String fileLocation = "file:///home/sam/work/projects/etl/prototype/gdf/wave_connector_prototype/sf_source_config.json";
		System.out.println(new File(fileLocation).isFile());
        FileUtils.readFileToString(new File(fileLocation), Charsets.UTF_8);
	}
}
