package dev.gojava.certificatevalidator.controler

import dev.gojava.certificatevalidator.service.CertificateService
import groovy.transform.CompileStatic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/validator")
@CompileStatic
@SuppressWarnings("GrMethodMayBeStatic")
@SuppressWarnings("unused")
class ValidatorController {

	private static final String INVALID_TEMPLATE_PAGE = "/page/validator/invalid"
	private static final String VALID_TEMPLATE_PAGE = "/page/validator/valid"

	private static final Logger LOG = LoggerFactory.getLogger(ValidatorController)

	@Autowired
	CertificateService certificateService

	@GetMapping("/")
	@SuppressWarnings("unused")
	ModelAndView getIndex(ModelAndView modelAndView) {
		modelAndView.viewName = "/page/validator/validator"
		return modelAndView
	}

	@PostMapping("/validate")
	@SuppressWarnings("unused")
	ModelAndView validate(@RequestParam("token") String token, ModelAndView modelAndView) {
		boolean tokenExist = false
		try {
			tokenExist = certificateService.tokenExist(token)
		} catch (Exception e) {
			LOG.error("Erro ao tentar validar token: ", e)
			modelAndView.viewName = "error"
		}

		if (!tokenExist) {
			modelAndView.viewName = INVALID_TEMPLATE_PAGE
		} else {
			modelAndView.viewName = VALID_TEMPLATE_PAGE
		}

		return modelAndView
	}
}
