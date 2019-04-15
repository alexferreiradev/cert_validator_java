package dev.gojava.certificatevalidator.controler

import dev.gojava.certificatevalidator.service.CertificateService
import groovy.transform.CompileStatic
import groovy.util.logging.Log4j2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/validator")
@CompileStatic
@Log4j2
class ValidatorController {

	private static final String INVALID_TEMPLATE_PAGE = "page/validator/invalid"
	private static final String VALID_TEMPLATE_PAGE = "page/validator/valid"

	@Autowired
	CertificateService certificateService

	@GetMapping("/")
	@ResponseBody
	@SuppressWarnings("unused")
	String getIndex() {
		return "/page/validator"
	}

	@GetMapping(name = "/validate")
	@SuppressWarnings("unused")
	String validate(@RequestParam("token") String token) {
		boolean tokenExist = certificateService.tokenExist(token)
		if (!tokenExist) {
			return INVALID_TEMPLATE_PAGE
		}

		return VALID_TEMPLATE_PAGE
	}
}
