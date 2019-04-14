package dev.gojava.certificatevalidator.service.exception

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class NotFoundException extends Exception {

	NotFoundException(String searchKey) {
		super("Não foi encontrado o model com chave de busca: ${searchKey}")
	}
}
