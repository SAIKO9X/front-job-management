package com.front.project.management.modules.candidate.service;

import com.front.project.management.modules.candidate.dto.Token;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CandidateService {

  public Token login(String email, String password) {
    RestTemplate rt = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, String> data = new HashMap<>();
    data.put("email", email);
    data.put("password", password);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

    var result = rt.postForObject("http://localhost:8080/candidate/auth", request, Token.class);

    System.out.println(result);

    return result;
  }
}