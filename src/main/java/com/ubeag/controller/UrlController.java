package com.ubeag.controller;

import com.ubeag.service.LinkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ubeag")
public class UrlController {

    private final LinkService linkService;

    public UrlController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("createshort")
    public String convertToShortLink(@RequestBody String request){

        return linkService.convertToShortLink(request);
    }
}
