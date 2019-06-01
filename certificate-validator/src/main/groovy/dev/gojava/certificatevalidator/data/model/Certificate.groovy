package dev.gojava.certificatevalidator.data.model


import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true)
class Certificate extends BaseModel {
	String totalHours
	String token
	/**
	 * Local relativo que o PDF pode ser encontrado
	 */
	String uri
	Event event
	Participant participant
}
