package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.arkhipov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;
@Slf4j
@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            String errorMessage = "Validation failed: " + bindingResult.getFieldError();
            log.error(errorMessage);
            throw new ValidationFailedException(errorMessage);
        }
        if (Objects.equals(bindingResult.getFieldValue("uid"), "123")) {
            throw new UnsupportedCodeException("Этот uid запрещён.");
        }
    }
}