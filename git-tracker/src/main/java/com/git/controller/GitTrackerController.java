package com.git.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.service.GitTrackerService;

@RestController
@RequestMapping("/git-tracker")
public class GitTrackerController {
	private static final Logger logger = LoggerFactory.getLogger(GitTrackerController.class);

	@Autowired
	private GitTrackerService gitTrackerService;

	@GetMapping("/test")
	public String getRestStatus() {
		return "Working!";
	}

	@GetMapping("/list-commits")
	public void getGitCommits() {
		gitTrackerService.getGitCommits();
	}

	@PostMapping("/webhook")
	public void handleGitHubWebhookEvent(@RequestBody String payload) {
		gitTrackerService.handleWebhooks(payload);
	}
}
