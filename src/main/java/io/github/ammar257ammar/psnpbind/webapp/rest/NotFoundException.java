package io.github.ammar257ammar.psnpbind.webapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
