package io.codefountain.spring.boot.all.jdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

	private long id;
	private String firstName, lastName;
}
