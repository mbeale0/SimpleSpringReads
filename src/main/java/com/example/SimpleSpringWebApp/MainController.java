package com.example.SimpleSpringWebApp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {

  @GetMapping("/Log")
  public String readLog(Model model) throws JsonMappingException, JsonProcessingException{
    final String uri = "http://localhost:8082/GetMessage";

    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);


    ObjectMapper objectMapper = new ObjectMapper();

    Message message = objectMapper.readValue(result, Message.class);

    ArrayList<Message> messages = new ArrayList<>();
    messages.add(message);

    model.addAttribute("messages", messages);


    return "Log";
  }



}