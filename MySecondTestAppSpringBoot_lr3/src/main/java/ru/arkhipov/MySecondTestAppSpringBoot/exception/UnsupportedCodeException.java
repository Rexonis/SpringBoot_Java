package ru.arkhipov.MySecondTestAppSpringBoot.exception;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class UnsupportedCodeException extends Exception {
    public UnsupportedCodeException(String message) {
        super(message);
        log.error("Unsupported code exception: {}", message);
    }
}


