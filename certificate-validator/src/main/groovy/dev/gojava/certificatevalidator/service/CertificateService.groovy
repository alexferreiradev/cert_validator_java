package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.data.repository.CertificateRepository
import dev.gojava.certificatevalidator.service.exception.NotFoundException
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@SuppressWarnings("unused")
@Service
@CompileStatic
class CertificateService {

	private CertificateRepository certificateRepository

	Certificate get(Long id) throws NotFoundException {
		return null
	}

	boolean tokenExist(String token) {
		return false
	}

	Certificate findByToken(String token) throws NotFoundException {
		return null
	}
}
