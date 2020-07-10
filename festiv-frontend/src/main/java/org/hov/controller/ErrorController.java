package org.hov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
public class ErrorController 
{
	@GetMapping("")
	public String error()
	{
		return "error";
	}
}
