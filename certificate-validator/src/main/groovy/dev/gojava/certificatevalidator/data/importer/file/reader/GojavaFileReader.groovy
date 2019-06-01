package dev.gojava.certificatevalidator.data.importer.file.reader

import dev.gojava.certificatevalidator.data.importer.exception.FileReaderException
import dev.gojava.certificatevalidator.data.importer.model.ObjectFromFile

interface GojavaFileReader<T extends ObjectFromFile> {

	List<T> importObjects(String filePath) throws FileReaderException

}
