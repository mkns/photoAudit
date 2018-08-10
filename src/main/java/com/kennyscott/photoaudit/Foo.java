package com.kennyscott.photoaudit;

import org.springframework.stereotype.Component;

@Component
public class Foo {

	public String foo;
	public String bar = "yak yak";

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

}
