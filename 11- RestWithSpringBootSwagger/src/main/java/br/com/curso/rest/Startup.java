package br.com.curso.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Startup {
   public static void main(String[] args) {
	   SpringApplication.run(Startup.class, args);
   }
}
