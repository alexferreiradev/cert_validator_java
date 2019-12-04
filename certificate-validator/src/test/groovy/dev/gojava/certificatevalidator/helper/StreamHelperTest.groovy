package dev.gojava.certificatevalidator.helper

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class StreamHelperTest {

	@Test
	void testParseStream() {
		InputStream stream = getClass().getResourceAsStream("/helper/stream/valid_json_file.json")
		String parseStream = StreamHelper.parseStream(stream)

		Assert.assertNotNull(parseStream)
		String expectedfileText = getClass().getResourceAsStream("/helper/stream/expected_valid_json_file.json").text
		Assert.assertEquals(expectedfileText, parseStream)
	}

	@Ignore("Nao foi impl")
	@Test
	void testCloseSafeInput() {
		InputStream stream = null
		StreamHelper.closeSafeInput(stream)
	}

	@Ignore("Nao foi impl")
	@Test
	void testCloseSafeOutput() {
		OutputStream stream = null
		StreamHelper.closeSafeOutput(stream)
	}
}
