package com.salesERP.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ERPmenu")
public class ERPHomeController {
	@GetMapping("/menu")
	public String dashBoard() {
		return "/erpMenu/menu";
	}
	@GetMapping("/empty")
	public String empty1() {
		return "/erpMenu/empty";
	}
	@GetMapping("/empty2")
	public String empty2() {
		return "/erpMenu/empty2";
	}
}
