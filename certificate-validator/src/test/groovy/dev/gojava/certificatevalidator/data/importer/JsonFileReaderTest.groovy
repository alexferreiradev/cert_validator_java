package dev.gojava.certificatevalidator.data.importer

import dev.gojava.certificatevalidator.data.importer.file.reader.JsonFileReader
import dev.gojava.certificatevalidator.data.importer.model.JsonFile
import dev.gojava.certificatevalidator.data.model.Certificate
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

import java.nio.file.Files
import java.nio.file.StandardCopyOption

class JsonFileReaderTest {

	@InjectMocks
	JsonFileReader reader

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	void testImportObjects() {
		createJsonFilesInTestBuildDir()
		List<JsonFile> importedObj = reader.importObjects(filePath)

		Assert.assertNotNull(importedObj)
		Assert.assertEquals(10, importedObj.size())
		JsonFile secondObj = importedObj.get(1)

		Assert.assertEquals("valid_json_file.json", secondObj.fileName)
		Assert.assertEquals("123", secondObj.integrityKey)
		List<Certificate> certificateList = secondObj.certificateList
		Assert.assertEquals(1, certificateList.size())
		Certificate firstCert = certificateList.get(0)
		Assert.assertEquals("123", firstCert.token)
	}

	private void createJsonFilesInTestBuildDir() {
		File projectDir = new File(getClass().getResource("/").toURI())
		File jsonDir = projectDir.toPath().resolve(JsonFileReader.JSON_FILES_DIR).toFile()
		jsonDir.mkdirs()
		File jsonFile = new File(getClass().getResource("/filereader/json/valid_json_file.json").toURI())
		Files.copy(jsonFile.toPath(), jsonDir.toPath(), StandardCopyOption.REPLACE_EXISTING)
		Files.copy(jsonFile.toPath(), jsonDir.toPath(), StandardCopyOption.ATOMIC_MOVE)
	}
}
