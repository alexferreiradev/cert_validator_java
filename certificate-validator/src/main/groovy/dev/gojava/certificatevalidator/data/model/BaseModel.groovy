package dev.gojava.certificatevalidator.data.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString
class BaseModel {
	Long id
	Date createdTimestamp
	Date updatedTimestamp
	Date deletedTimestamp
}
