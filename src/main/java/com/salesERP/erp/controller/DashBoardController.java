package com.salesERP.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashBoardController {
	// add mapping for dashboard link
	@GetMapping("/contents")
	public String dashBoardContents() {
		return "/erpMenu/dashboard/dashboardContents";
	}
}
