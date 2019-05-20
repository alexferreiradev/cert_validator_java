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
		Mockito.when(repository.findDistinctByToken(validToken)).thenReturn(Optional.of(cert1))

		boolean tokenExist = service.tokenExist(validToken)

		Assert.assertTrue(tokenExist)
	}

	@Test
	void certificateCanBeFound_whenRepositoryHas() {
		String validToken = "123"
		Certificate cert1 = Mockito.mock(Certificate)
		Mockito.when(repository.findDistinctByToken(validToken)).thenReturn(Optional.of(cert1))

		Certificate byToken = service.findByToken(validToken)

		Assert.assertNotNull(byToken)
	}

	@Test
	void certificateCanBeFound_whenRepositoryHasById() {
		Long validId = Long.valueOf(1)
		Certificate cert1 = Mockito.mock(Certificate)
		Mockito.when(cert1.id).thenReturn(validId)
		Mockito.when(repository.findById(validId)).thenReturn(Optional.of(cert1))

		Certificate byToken = service.get(validId)

		Assert.assertNotNull(byToken)
	}

//	 +++++++++++++++++++++++++++++++++++++ Testes negativos e de tickets
	@Test
	void invalidIdThrowNotFound_whenRepositoryThrowAnyError() {
		Long invalidId = Long.valueOf(1)
		Mockito.when(repository.findById(invalidId)).thenThrow(RuntimeException.class)

		expectedException.expect(NotFoundException)
		expectedException.expectMessage("Não foi encontrado o model devido erro interno")
		service.get(invalidId)
	}

	@Test
	void invalidTokenThrowNotFound_whenRepositoryThrowAnyError() {
		String invalidToken = "123"
		Mockito.when(repository.findDistinctByToken(invalidToken)).thenThrow(RuntimeException.class)

		expectedException.expect(NotFoundException)
		expectedException.expectMessage("Não foi encontrado o model devido erro interno")
		service.findByToken(invalidToken)
	}
}
