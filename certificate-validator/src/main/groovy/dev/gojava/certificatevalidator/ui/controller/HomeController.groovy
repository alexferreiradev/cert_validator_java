package dev.gojava.certificatevalidator.ui.controller

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
@CompileStatic
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
