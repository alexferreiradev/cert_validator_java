package dev.gojava.certificatevalidator.data.reader.exception

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class FileReaderException extends Exception {

	FileReaderException(String message) {
		super(message)
	}

	FileReaderException(String message, Throwable cause) {
		super(message, cause)
	}

	FileReaderException(Throwable cause) {
		super(cause)
	}

	protected FileReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace)
	}
}
