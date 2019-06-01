package dev.gojava.certificatevalidator.data.model

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class Event extends BaseModel {
	String name
	String talkerName
	String abstractText
	String place
	Date startTimestamp
	Date endTimestamp
}
