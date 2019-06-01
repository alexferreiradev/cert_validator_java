package dev.gojava.certificatevalidator.data.importer

import dev.gojava.certificatevalidator.data.importer.file.reader.JsonFileReader
import dev.gojava.certificatevalidator.data.importer.model.JsonFile
import dev.gojava.certificatevalidator.data.model.Certificate
import org.junit.After
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
	private File jsonDir

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this)
	}

	@After
	void tearDown() throws Exception {
		destroyJsonDir(jsonDir)
	}

	private static void destroyJsonDir(File file) {
		boolean delete = file.deleteDir()
		if (!delete) {
			Assert.fail("Pasta com arquivos de testes não pode ser removida, remova antes de executar novo teste")
		}
	}

	@Test
	void testImportObjects() {
		int jsonFilesTotal = 10
		createJsonFilesInTestBuildDir(jsonFilesTotal)
		List<JsonFile> importedObj = reader.importObjects()

		Assert.assertNotNull(importedObj)
		Assert.assertEquals(jsonFilesTotal, importedObj.size())
		JsonFile secondObj = importedObj.get(1)

		Assert.assertEquals("1valid_json_file.json", secondObj.fileName)
		Assert.assertEquals("12345566676", secondObj.integrityKey)
		List<Certificate> certificateList = secondObj.certificateList
		Assert.assertEquals(2, certificateList.size())
		Certificate firstCert = certificateList.get(0)
		Assert.assertEquals("1234", firstCert.token)
		Assert.assertEquals("Participante teste", firstCert.participant.name)
		Assert.assertEquals("1234567", firstCert.participant.identifier)
	}

	private void createJsonFilesInTestBuildDir(int total) {
		File projectDir = new File(getClass().getResource("/").toURI())
		jsonDir = projectDir.toPath().parent.resolve(JsonFileReader.JSON_FILES_DIR).toFile()
		this.jsonDir.mkdirs()
		File jsonFile = new File(getClass().getResource("/filereader/json/valid_json_file.json").toURI())
		for (int i = 0; i < total; i++) {
			Files.copy(jsonFile.toPath(), this.jsonDir.toPath().resolve(i.toString() + jsonFile.name), StandardCopyOption.REPLACE_EXISTING)
		}
	}
}
