package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.data.repository.CertificateRepository
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
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@CompileStatic
@RunWith(JUnit4.class)
class CertificateServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none()

	@Mock
	CertificateRepository repository

	@InjectMocks
	CertificateService service

	@Before
	void setUp() {
		MockitoAnnotations.initMocks(this)
	}

	//	 +++++++++++++++++++++++++++++++++++++ Testes de comportamentos

	@Test
	void tokenExist_whenHasCertificateToken() {
		Certificate cert1 = Mockito.mock(Certificate)
		String validToken = "123"
		Mockito.when(cert1.token).thenReturn(validToken)
		List<Certificate> fakeList = [cert1]
		Mockito.when(repository.findAll()).thenReturn(fakeList)

		boolean tokenExist = service.tokenExist(validToken)

		Assert.assertTrue(tokenExist)
	}

	@Test
	void certificateCanBeFound_whenRepositoryHas() {
		Certificate cert1 = Mockito.mock(Certificate)
		String validToken = "123"
		Mockito.when(cert1.token).thenReturn(validToken)
		List<Certificate> fakeList = [cert1]
		Mockito.when(repository.findAll()).thenReturn(fakeList)

		Certificate byToken = service.findByToken(validToken)

		Assert.assertNotNull(byToken)
	}

	@Test
	void certificateCanBeFound_whenRepositoryHasById() {
		Certificate cert1 = Mockito.mock(Certificate)
		Long validId = Long.valueOf(1)
		Mockito.when(cert1.id).thenReturn(validId)
		List<Certificate> fakeList = [cert1]
		Mockito.when(repository.findAll()).thenReturn(fakeList)

		Certificate byToken = service.get(validId)

		Assert.assertNotNull(byToken)
	}

//	 +++++++++++++++++++++++++++++++++++++ Testes negativos e de tickets
	@Test
	void invalidTokenThrowNotFound_whenRepositoryThrowAnyError() {
		String invalidToken = "123"
		Mockito.when(repository.findAll()).thenThrow(RuntimeException.class)

		expectedException.expect(NotFoundException)
		service.findByToken(invalidToken)
	}
}
