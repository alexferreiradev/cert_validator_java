package dev.gojava.certificatevalidator.service

import dev.gojava.certificatevalidator.data.model.Certificate
import dev.gojava.certificatevalidator.service.exception.NotFoundException
import groovy.transform.CompileStatic

@SuppressWarnings("unused")
@CompileStatic
interface CertificateService {

	Certificate get(Long id) throws NotFoundException

	boolean tokenExist(String token)

	Certificate findByToken(String token) throws NotFoundException
}
