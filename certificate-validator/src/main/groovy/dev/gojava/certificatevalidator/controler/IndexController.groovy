package dev.gojava.certificatevalidator.controler

import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
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

	@PostMapping("/validator")
	@SuppressWarnings("unused")
	ModelAndView getValidator(@RequestParam("token") String token, ModelAndView modelAndView) {
		modelAndView.viewName = "page/validator/validator.html"
		modelAndView.model.put("token", token)
		modelAndView.model.put("humanStatus", "Válido")

		return modelAndView
	}

	@GetMapping("/validator")
	@SuppressWarnings("unused")
	ModelAndView getPageGValidator(ModelAndView modelAndView) {
		modelAndView.viewName = "index.html"

		return modelAndView
	}

}
