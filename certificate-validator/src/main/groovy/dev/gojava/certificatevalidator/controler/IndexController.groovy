package dev.gojava.certificatevalidator.controler

import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
@CompileStatic
@SuppressWarnings("GrMethodMayBeStatic")
@SuppressWarnings("unused")
class IndexController {

	@GetMapping("/")
	@SuppressWarnings("unused")
	String getIndex() {
		return "index"
	}

}
