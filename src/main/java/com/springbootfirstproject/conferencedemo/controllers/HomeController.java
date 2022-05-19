package com.springbootfirstproject.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    private String appVersion;

    @Value("${app.version}") // will get app.version property from application properties files
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @GetMapping
    public Map<String, String> getStatus() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("app-verison", appVersion);
        return map;

    }
}
