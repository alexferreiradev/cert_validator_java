package dev.gojava.certificatevalidator.data.importer.file.reader

import com.google.gson.Gson
import dev.gojava.certificatevalidator.data.importer.exception.FileReaderException
import dev.gojava.certificatevalidator.data.importer.model.JsonFile
import dev.gojava.certificatevalidator.helper.StreamHelper
import groovy.transform.CompileStatic

@CompileStatic
class JsonFileReader implements GojavaFileReader<JsonFile> {

	public static final String JSON_FILES_DIR = "json_files"

	@Override
	List<JsonFile> importObjects(String filePath) throws FileReaderException {
		File jsonFilesDir = buildJsonDir()
		validateDiretory(jsonFilesDir)
		File[] jsonFiles = createFileList(jsonFilesDir)
		List<JsonFile> models = createJsonList(jsonFiles)

		return models
	}

	private File buildJsonDir() {
		File projectPath = new File(getClass().getResource("/").toURI())
		File projectFile = projectPath.toPath().parent.toFile()
		File jsonFilesDir = projectFile.toPath().resolve(JSON_FILES_DIR).toFile()
		return jsonFilesDir
	}

	private static File[] createFileList(File jsonFilesDir) {
		File[] jsonFiles = jsonFilesDir.listFiles(new FileFilter() {
			@Override
			boolean accept(File pathname) {
				return pathname.name.endsWith(".json")
			}
		})
		return jsonFiles
	}

	private static List<JsonFile> createJsonList(File[] jsonFiles) {
		List<JsonFile> models = []
		jsonFiles.toList().stream().forEach({ File jsonFile ->
			InputStream stream = new FileInputStream(jsonFile)
			String jsonText = StreamHelper.parseStream(stream)
			JsonFile jsonFileObj = importBaseModel(jsonText)
			jsonFileObj.fileName = jsonFile.name

			models.add(jsonFileObj)
		})

		return models
	}

	private static JsonFile importBaseModel(String jsonText) {
		Gson gson = new Gson()
		JsonFile fromJson = gson.fromJson(jsonText, JsonFile)
		return fromJson
	}

	private static void validateDiretory(File jsonFilesDir) {
		if (!jsonFilesDir.exists()) {
			throw new IllegalStateException("Não foi possível encontrar o diretório: ${jsonFilesDir.absolutePath}")
		}
	}

}
