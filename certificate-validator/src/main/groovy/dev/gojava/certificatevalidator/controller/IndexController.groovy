package dev.gojava.certificatevalidator.controller

import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@CompileStatic
@SuppressWarnings("GrMethodMayBeStatic")
@SuppressWarnings("unused")
class IndexController {

	@GetMapping("/")
	@SuppressWarnings("unused")
	ModelAndView getIndex(ModelAndView modelAndView) {
		modelAndView.model.put("name", "Alex Rabelo Ferreira")
		modelAndView.viewName = "index"

		return modelAndView
	}

	@GetMapping("/validator")
	@SuppressWarnings("unused")
	ModelAndView getPageGValidator(ModelAndView modelAndView) {
		modelAndView.viewName = "index.html"

		return modelAndView
	}

}
