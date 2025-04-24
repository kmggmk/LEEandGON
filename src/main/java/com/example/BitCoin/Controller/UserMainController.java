package com.example.BitCoin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
	
	@GetMapping("/main")
	public String userMainPage() {
		return "main";
	}
}
