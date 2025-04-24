package com.example.BitCoin.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class testController {

	// SLF4J Logger 사용
	private static final Logger logger = LoggerFactory.getLogger(testController.class);

	@GetMapping("/login")
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			Authentication authentication) {

		// 인증 정보와 에러, 로그아웃 메시지 출력
		logger.debug("Current authentication: {}", authentication);
		logger.debug("Error parameter: {}", error);
		logger.debug("Logout parameter: {}", logout);

		if (authentication != null && authentication.isAuthenticated()) {
			// 이미 인증된 사용자는 /home으로 리디렉션
			return "redirect:/home";
		}

		if (error != null) {
			model.addAttribute("error", "로그인 실패!");
		}

		if (logout != null) {
			model.addAttribute("message", "로그아웃 되었습니다.");
		}

		

		return "login";
	}

	@GetMapping("/home")
	@PreAuthorize("hasRole('USER')")
	public String home() {
		return "home";
	}
}
