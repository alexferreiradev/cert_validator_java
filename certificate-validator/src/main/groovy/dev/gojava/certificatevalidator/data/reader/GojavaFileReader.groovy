package dev.gojava.certificatevalidator.data.reader


import dev.gojava.certificatevalidator.data.model.BaseModel
import dev.gojava.certificatevalidator.data.reader.exception.FileReaderException

interface GojavaFileReader {

	List<BaseModel> importObjects(String filePath) throws FileReaderException

}
