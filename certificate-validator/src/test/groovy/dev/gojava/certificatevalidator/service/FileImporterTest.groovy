package dev.gojava.certificatevalidator.service

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.context.event.ContextRefreshedEvent

class FileImporterTest {

	@Mock
	CertificateService certificateService

	@InjectMocks
	FileImporter importer

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this)
		//todo  criar arquivos em pasta json_files
	}

	@After
	void tearDown() throws Exception {
		// todo Apagar arquivos em pasta json_files
	}

	@Ignore("Tem que criar arquivos em pasta")
	@Test()
	void whenCallOnApplication_callsaveOnService() {
		ContextRefreshedEvent event = Mockito.mock(ContextRefreshedEvent)

		importer.onApplicationEvent(event)

		Mockito.verify(certificateService, Mockito.only()).saveCertificatesImported(Mockito.anyList())
	}

	@Test(expected = IllegalStateException)
	void whenCallOnApplicationWithoutValidJson_throwError() {
		ContextRefreshedEvent event = Mockito.mock(ContextRefreshedEvent)

		importer.onApplicationEvent(event)
		Assert.fail("Não pode chegar aqui")
	}
}
