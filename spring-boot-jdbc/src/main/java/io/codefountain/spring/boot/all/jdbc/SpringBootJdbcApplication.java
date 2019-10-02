package io.codefountain.spring.boot.all.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import io.codefountain.spring.boot.all.jdbc.domain.Person;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE persons IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE persons (id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
		
		List<Object[]> names = Arrays.asList("John Doe", "Dhokia Grewall", "Josua Bloch", "Dave Syer")
		.stream()
		.map(name -> name.split(" "))
		.collect(Collectors.toList());
		
		names.forEach(name -> log.info(String.format("Person name is %s %s", name[0], name[1])));
		
		jdbcTemplate.batchUpdate("INSERT INTO persons(first_name, last_name) VALUES(?,?)", names);
		
		jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM persons WHERE first_name=?", new Object[] {"John"}, 
				(rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		).forEach(p -> log.info(p.toString()));
	}

}
