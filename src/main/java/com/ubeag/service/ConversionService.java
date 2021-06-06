package com.ubeag.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    private static final String allowString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowChars = allowString.toCharArray();
    private int lengthOfAllowed = allowChars.length;

    public String shorten(long inputID){
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

    //method to search for short url
}
