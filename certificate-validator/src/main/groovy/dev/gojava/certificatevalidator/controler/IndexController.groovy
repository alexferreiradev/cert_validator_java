package dev.gojava.certificatevalidator.controler


import groovy.transform.CompileStatic
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
@CompileStatic
@SuppressWarnings("GrMethodMayBeStatic")
@SuppressWarnings("unused")
class IndexController {

	@GetMapping("/")
	@ResponseBody
	@SuppressWarnings("unused")
	String getIndex() {
		return "index"
	}

}
