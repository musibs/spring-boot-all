package io.codefountain.spring.boot.all.restservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Greeting {

	private final int id;
	private final String message;
}
