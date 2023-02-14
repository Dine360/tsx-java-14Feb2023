package com.git.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.git.controller.GitTrackerController;

@Service
public class GitTrackerService {

	private static final Logger logger = LoggerFactory.getLogger(GitTrackerService.class);

	private static final String GIT_API = "https://api.github.com/repos";
	private static final String GIT_OWNER = "Dine360";
	private static final String GIT_REPO = "dummy-github-events";

	public void getGitCommits() {
		String URL = GIT_API + "/" + GIT_OWNER + "/" + GIT_REPO + "/commits";
		try {
			RestTemplate restTemplate = new RestTemplate();
			String response = restTemplate.getForObject(URL, String.class);
			logger.info("Commit Details");
			logger.info(response);
		} catch (Exception e) {
			logger.error("Exception occured while calling Git API", e);
		}
	}

	public void handleWebhooks(String eventInfo) {
		logger.info("Git hub webhook event");
		logger.info(eventInfo);
	}
}
