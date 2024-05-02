package br.com.cars.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;


public enum Status {
	@JsonEnumDefaultValue
	NO_STATE,
	NEW,
	PRE_OWNED
	

}
