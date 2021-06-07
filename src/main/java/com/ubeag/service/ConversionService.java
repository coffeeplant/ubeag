package com.ubeag.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    private static Logger logger = LoggerFactory.getLogger(ConversionService.class);
    private static final String allowString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowChars = allowString.toCharArray();
    private int lengthOfAllowed = allowChars.length;

    public String shorten(Long inputID){
        var shortenedString = new StringBuilder();
        if (inputID == 0){
            return String.valueOf(allowChars[0]);
        }
        while (inputID > 0){
            shortenedString.append(allowChars[(int) (inputID % lengthOfAllowed)]);
            inputID = inputID/ lengthOfAllowed;
        }

        return shortenedString.reverse().toString();
    }

    public long unShorten(String shortLink){
        var chars = shortLink.toCharArray();
        int length = chars.length;

        long decodedID =0;

        int counter = 1;
        for (int i = 0; i<length; i++){
            decodedID += allowString.indexOf(chars[i]) * Math.pow(lengthOfAllowed, length - counter);
            counter++;
        }
        return decodedID;
    }

}
