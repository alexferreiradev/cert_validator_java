package dev.gojava.certificatevalidator.data.importer.model

import dev.gojava.certificatevalidator.data.model.Certificate
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString
class JsonFile extends ObjectFromFile {
	String integrityKey
	List<Certificate> certificateList
}
