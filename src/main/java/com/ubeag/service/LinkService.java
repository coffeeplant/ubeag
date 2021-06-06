package com.ubeag.service;

import com.ubeag.model.Link;
import com.ubeag.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private static Logger logger = LoggerFactory.getLogger(LinkService.class);
    private final LinkRepository linkRepository;
    private final ConversionService conversionService;

    public LinkService(LinkRepository linkRepository, ConversionService conversionService){
        this.linkRepository = linkRepository;
        this.conversionService = conversionService;
    }

    public String convertToShortLink(String request){
        logger.info("Entering convertToShortLink");
        var link = new Link();
        logger.info("create new link");
        link.setLongLink(request);
        logger.info("setlonglink");
        var entity = linkRepository.save(link);
        String test= conversionService.shorten(link.getId());
        logger.info("test:");
        logger.info(test);
        return test;
    }
}
