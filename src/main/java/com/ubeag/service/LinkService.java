package com.ubeag.service;

import com.ubeag.model.Link;
import com.ubeag.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private final LinkRepository linkRepository;
    private final ConversionService conversionService;

    public LinkService(LinkRepository linkRepository, ConversionService conversionService){
        this.linkRepository = linkRepository;
        this.conversionService = conversionService;
    }

    public String convertToShortLink(String request){
        var link = new Link();
        link.setLongLink(request);
        link.setShortLink(conversionService.shorten(link.getId()));

       // var entity = linkRepository.saveAndFlush(link);
        System.out.println(link.getShortLink());
        return link.getShortLink();
    }
}
