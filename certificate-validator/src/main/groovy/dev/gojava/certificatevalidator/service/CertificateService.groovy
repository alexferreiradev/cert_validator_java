package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.service.exception.NotFoundException
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@SuppressWarnings("unused")
@Service
@CompileStatic
class CertificateService {

	private List<Certificate> certificates

	boolean tokenExist(String token) {
		try {
			return findByToken(token) != null
		} catch (Exception ignored) {
		}

		return false
	}

	Certificate findByToken(String token) throws NotFoundException {
		NotFoundException notFoundException = new NotFoundException("token", token)
		Optional<Certificate> byToken = Optional.empty()
		try {
			byToken = findCertificateByToken(token)
		} catch (Exception e) {
			notFoundException = new NotFoundException(e)
		}

		return byToken.orElseThrow({ -> notFoundException })
	}

	Optional<Certificate> findCertificateByToken(String token) {
		Optional<Certificate> findFirst = certificates.stream().filter({ it.token == token }).findFirst()
		return findFirst
	}

	void saveCertificatesImported(List<Certificate> certificates) {
		this.certificates = certificates
	}
}
