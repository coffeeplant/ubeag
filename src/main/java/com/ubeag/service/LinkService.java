package com.ubeag.service;

import com.ubeag.model.Link;
import com.ubeag.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
        var link = new Link();
        link.setLongLink(request);
        var newRow = linkRepository.saveAndFlush(link);
        String converted= conversionService.shorten(link.getId());
        return converted;
    }

    public String getOriginalLink(String shortLink){
        var id = conversionService.unShorten(shortLink);
        var link = linkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Long Link matches" + shortLink));

        return link.getLongLink();
    }
}
