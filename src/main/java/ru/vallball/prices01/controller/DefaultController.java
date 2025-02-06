package ru.vallball.prices01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("default")
public class DefaultController {
	@GetMapping("example")
	public String getExample() {
		return "tst";
	}

}
