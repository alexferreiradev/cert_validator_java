package dev.gojava.certificatevalidator.data.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class Participant extends BaseModel {
	String name
	String lastName
	/**
	 * Identificador do participante no país. Pode ser RG, CPF ou passaporte
	 */
	String identifier
}
