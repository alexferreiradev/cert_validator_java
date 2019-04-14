package dev.gojava.certificatevalidator.controler

import dev.gojava.certificatevalidator.service.CertificateService
import groovy.transform.CompileStatic
import groovy.util.logging.Log4j2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@CompileStatic
@Log4j2
class ValidatorController {

	@Autowired
	CertificateService certificateService

	@GetMapping("/validateToken")
	String validate(@RequestParam("token") String token) {
		boolean tokenExist = certificateService.tokenExist(token)
		if (!tokenExist) {
			return "invalid"
		}

		return "valid"
	}
}
