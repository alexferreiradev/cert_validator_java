package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.stereotype.Service

@Service
@CompileStatic
@EqualsAndHashCode(callSuper = true)
@ToString(includeFields = true, includeSuper = true)
class CertificateService {

	List<Certificate> getAllCertificate() {
		return null
	}

}
