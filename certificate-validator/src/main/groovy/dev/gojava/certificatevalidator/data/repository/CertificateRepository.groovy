package dev.gojava.certificatevalidator.data.repository

import dev.gojava.certificatevalidator.data.model.Certificate
import org.springframework.data.repository.CrudRepository

interface CertificateRepository extends CrudRepository<Certificate, Long> {

	Optional<Certificate> findDistinctByToken(String token)

}