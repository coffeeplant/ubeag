package com.ubeag.controller;

import com.ubeag.service.LinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/ubeag")
public class UrlController {

    private static Logger logger = LoggerFactory.getLogger(UrlController.class);
    private final LinkService linkService;

    public UrlController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/createshort")
    public String convertToShortLink(@RequestBody String request) {
        if(request.startsWith("http://") || request.startsWith("https://")) {
            String shortLink = linkService.convertToShortLink(request);
            return "ubeag/" + shortLink + "\n";
        }else{
            return "Invalid URL, please add http:// or https://\n";
        }
    }

    @GetMapping(value = "/{shortLink}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortLink) throws URISyntaxException {
        logger.info("get request shortLink:");
        logger.info(shortLink);
        logger.info("linkService");

            return ResponseEntity.status(HttpStatus.FOUND)
                    //.location(URI.create(linkService.getOriginalLink(shortLink)))
                    .location(URI.create(linkService.getOriginalLink(shortLink)))
                    .build();

    }

//    @RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
//    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortLink, HttpServletResponse response) {
////        var url = ;
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .location(URI.create(linkService.getOriginalLink(shortLink)))
//                .build();
//    }

//    @RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
//    public String getAndRedirect(@PathVariable String shortLink, HttpServletResponse response) throws URISyntaxException, IOException {
//        logger.info("get request shortLink:");
//        logger.info(shortLink);
//        var url = linkService.getLongLink(shortLink);
//        response.sendRedirect(url);
//        return "redirected to" +url;
//    }
}
