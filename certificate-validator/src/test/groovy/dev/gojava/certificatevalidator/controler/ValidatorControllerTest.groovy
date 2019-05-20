package dev.gojava.certificatevalidator.controler

import dev.gojava.certificatevalidator.application.CertificateValidatorApplication
import dev.gojava.certificatevalidator.service.CertificateService
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner)
@ContextConfiguration(classes = CertificateValidatorApplication)
@WebMvcTest(ValidatorController)
class ValidatorControllerTest {

	@Autowired
	MockMvc mockMvc

	@MockBean
	CertificateService certificateService

	@Test
	void validate_returnValidToken() {
		String validToken = "123"
		Mockito.when(certificateService.tokenExist(validToken)).thenReturn(true)

		mockMvc.perform(
				MockMvcRequestBuilders.get("/validateToken"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("valid")))
	}

	@Test
	void validate_returnInvalidToken() {
		String invalidToken = "123"
		Mockito.when(certificateService.tokenExist(invalidToken)).thenReturn(false)

		mockMvc.perform(
				MockMvcRequestBuilders.get("/validateToken"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("invalid")))
	}
}
