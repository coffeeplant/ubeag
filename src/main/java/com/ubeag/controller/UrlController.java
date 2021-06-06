package com.ubeag.controller;

import com.ubeag.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/ubeag")
public class UrlController {

    private final LinkService linkService;

    public UrlController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("createshort")
    public String convertToShortLink(@RequestBody String request){
        String shortLink = linkService.convertToShortLink(request);
        return "ubeag/"+shortLink+"\n";
    }

    @GetMapping(value = "{shortLink)")
    public ResponseEntity<Void> getandRedirect(@PathVariable String shortLink){
        var link = linkService.getLongLink(shortLink);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(link))
                .build();

    }
}
