
package com.spring.boot.ems.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestErrorController {

    @RequestMapping("/testError")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }


}
