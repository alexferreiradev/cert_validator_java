package dev.gojava.certificatevalidator.data.importer.model

import com.google.gson.annotations.SerializedName
import dev.gojava.certificatevalidator.data.model.Certificate
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString
class JsonFile extends ObjectFromFile {
//	@SerializedName("integrity_key")
	String integrityKey
	@SerializedName("certificates")
	List<Certificate> certificateList
}
