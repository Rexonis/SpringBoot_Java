package ru.arkhipov.MySecondTestAppSpringBoot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Response;
import ru.arkhipov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.time.ZonedDateTime;

@Service
@Qualifier("ModifySystemTimeResponseService")
public class ModifySystemTimeResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {
        response.setSystemTime(ZonedDateTime.now().format(DateTimeUtil.getCustomFormat()));
        return response;
    }
}