package com.hellmanstudios.friendform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FallbackController {

    @GetMapping("*")
    @ResponseBody
    public String getMethodName() {
        return "Nothing here. Try /add";
    }
    

}
