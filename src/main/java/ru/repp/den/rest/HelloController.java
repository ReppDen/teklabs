package ru.repp.den.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping({ "/me" })
    @ResponseBody
    public Map<String, Object> user(Principal principal) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("username",principal.getName());
        return m;
    }
}
