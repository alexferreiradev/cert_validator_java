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
		NotFoundException notFoundException = new NotFoundException("id", String.valueOf(id))
		Optional<Certificate> byId = Optional.empty()
		try {
			byId = certificateRepository.findById(id)
		} catch (Exception e) {
			notFoundException = new NotFoundException(e)
		}
		return byId.orElseThrow({ -> notFoundException })
	}

	boolean tokenExist(String token) {
		return findByToken(token)
	}

	Certificate findByToken(String token) throws NotFoundException {
		NotFoundException notFoundException = new NotFoundException("token", token)
		Optional<Certificate> byToken = Optional.empty()
		try {
			byToken = certificateRepository.findDistinctByToken(token)
		} catch (Exception e) {
			notFoundException = new NotFoundException(e)
		}

		return byToken.orElseThrow({ -> notFoundException })
	}
}
