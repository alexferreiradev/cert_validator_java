package dev.gojava.certificatevalidator.data.reader

import dev.gojava.certificatevalidator.data.model.BaseModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class JsonFileReaderTest {

	@InjectMocks
	JsonFileReader reader

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	void testImportObjects() {
		String filePath = ""
		List<BaseModel> importedObj = reader.importObjects(filePath)

		Assert.assertNotNull(importedObj)
	}
}
