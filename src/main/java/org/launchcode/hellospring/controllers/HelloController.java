package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @GetMapping()
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //handles request at path "goodbye"
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello'>" +
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
