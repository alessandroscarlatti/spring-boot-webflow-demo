package com.scarlatti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ~     _____                                    __
 * ~    (, /  |  /)                /)         (__/  )      /)        ,
 * ~      /---| // _ _  _  _ __  _(/ __ ___     / _ _  __ // _ _/_/_
 * ~   ) /    |(/_(//_)/_)(_(/ ((_(_/ ((_)   ) / (_(_(/ ((/_(_((_(__(_
 * ~  (_/                                   (_/
 * ~  Monday, 10/30/2017
 */
@Controller
@RequestMapping("/ui")
public class AppController {

    /**
     * show failure for now...
     *
     * @param name name from request params
     * @param m model to be sent to the template
     * @return the view for this endpoint
     */
    @GetMapping("/{view}")
    public String api(@RequestParam(value="name", defaultValue="Alessandro") String name,
                      @PathVariable("view") String view, Model m) {
        m.addAttribute("name", name);
        return view;
    }
}
