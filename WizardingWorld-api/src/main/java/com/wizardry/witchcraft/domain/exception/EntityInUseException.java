package com.wizardry.witchcraft.domain.exception;

public class EntityInUseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityInUseException(String mensagem) {
		super(mensagem);
	}

}
