package dev.gojava.certificatevalidator.ui.controller

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class HomeController {

	@GetMapping("/")
	def index() {
		return "index"
	}

	@GetMapping("/validator")
	def certValidator() {
		return "validator"
	}
}
