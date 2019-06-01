package dev.gojava.certificatevalidator.data.reader

import dev.gojava.certificatevalidator.data.model.BaseModel
import dev.gojava.certificatevalidator.data.reader.exception.FileReaderException
import groovy.transform.CompileStatic

@CompileStatic
class JsonFileReader implements GojavaFileReader {

	@Override
	List<BaseModel> importObjects(String filePath) throws FileReaderException {

		return null
	}

}
