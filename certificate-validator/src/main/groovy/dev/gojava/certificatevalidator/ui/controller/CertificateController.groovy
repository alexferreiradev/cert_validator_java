package dev.gojava.certificatevalidator.ui.controller

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@CompileStatic
class CertificateController {

	@RequestMapping(method = RequestMethod.POST, path = "/validator/search-token")
	def methodMissing(
			@RequestParam(required = true) String token
	) {
		return "validator"
	}
}
