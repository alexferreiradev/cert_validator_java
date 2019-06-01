package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.service.exception.NotFoundException
import groovy.transform.CompileStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@CompileStatic
@RunWith(JUnit4.class)
class CertificateServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none()

	@Mock
	List<Certificate> certificates

	@InjectMocks
	CertificateService service

	@Before
	void setUp() {
		MockitoAnnotations.initMocks(this)
	}

	//	 +++++++++++++++++++++++++++++++++++++ Testes de comportamentos

	@Test
	void tokenExist_whenHasCertificateToken() {
		String validToken = "123"
		Certificate invalidCert = new Certificate()
		Certificate validCert = new Certificate()
		validCert.token = validToken
		List<Certificate> fakeCertificates = [
				invalidCert,
				validCert
		]
		service.saveCertificatesImported(fakeCertificates)

		boolean tokenExist = service.tokenExist(validToken)

		Assert.assertTrue(tokenExist)
	}

	@Test
	void certificateCanBeFound_whenTokenIsValid() {
		String validToken = "123"
		Certificate invalidCert = new Certificate()
		Certificate validCert = new Certificate()
		validCert.token = validToken
		List<Certificate> fakeCertificates = [
				invalidCert,
				validCert
		]
		service.saveCertificatesImported(fakeCertificates)
		Certificate byToken = service.findByToken(validToken)

		Assert.assertNotNull(byToken)
	}

//	 +++++++++++++++++++++++++++++++++++++ Testes negativos e de tickets

	@Test
	void invalidTokenThrowNotFound_whenRepositoryThrowAnyError() {
		String invalidToken = "123"
		service.saveCertificatesImported(null)

		expectedException.expect(NotFoundException)
		expectedException.expectMessage("Não foi encontrado o model devido erro interno")
		service.findByToken(invalidToken)
	}

	@Test
	void tokenExistNotThrowError_whenThrowAnyErrorIntern() {
		String invalidToken = "123"
		service.saveCertificatesImported(null)

		boolean exist = service.tokenExist(invalidToken)
		Assert.assertFalse(exist)
	}
}
