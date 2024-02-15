package com.example.namelist;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NameListController {
    private final StringBuilder names = new StringBuilder();
    private int index = 0;

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("list")
    public String list() {
        return names.toString();
    }

    @PostMapping("add")
    public synchronized void add(@Size(max = 30) String name, HttpServletResponse response) throws IOException {
        final String redirectUrl = "http://localhost:8080/list";
        index++;
        names.append(index);
        names.append(") ");
        names.append(name);
        names.append("<br/>");
        response.sendRedirect(redirectUrl);
    }
}
