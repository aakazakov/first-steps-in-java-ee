package dev.fun.hello.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HelloController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String hello = "HEY! WE'VE COME WITH PEACE!";

	public String sayHello() {
		return hello;
	}
	
}
