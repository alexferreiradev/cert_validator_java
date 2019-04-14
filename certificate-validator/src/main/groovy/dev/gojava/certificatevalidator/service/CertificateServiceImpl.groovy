package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.service.exception.NotFoundException
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@Service
@CompileStatic
class CertificateServiceImpl implements CertificateService {

	@Override
	Certificate get(Long id) throws NotFoundException {
		return null
	}

	@Override
	boolean tokenExist(String token) {
		return false
	}

	@Override
	Certificate findByToken(String token) throws NotFoundException {
		return null
	}
}
