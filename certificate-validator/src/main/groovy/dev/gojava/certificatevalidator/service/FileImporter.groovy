package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.importer.file.reader.GojavaFileReader
import dev.gojava.certificatevalidator.data.importer.file.reader.JsonFileReader
import dev.gojava.certificatevalidator.data.importer.model.JsonFile
import dev.gojava.certificatevalidator.data.model.Certificate
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
@CompileStatic
class FileImporter {

	@Autowired
	CertificateService certificateService

	@EventListener
	void onApplicationEvent(ContextRefreshedEvent event) {
		println "Iniciando importação de arquivos json com informações de certificados"

		GojavaFileReader<JsonFile> reader = new JsonFileReader()
		List<JsonFile> jsonFiles = []
		try {
			jsonFiles = reader.importObjects()
		} catch (Exception e) {
			println "Erro ao importar: ${e.message}"
			println "Erro ao tentar importar arquivos JSON, aplicação irá terminar"

			System.exit(-1)
		}
		List<Certificate> certificates = jsonFiles.findResults { JsonFile json ->
			return json.certificateList
		}.flatten() as List<Certificate>

		certificateService.saveCertificatesImported(certificates)
	}
}
