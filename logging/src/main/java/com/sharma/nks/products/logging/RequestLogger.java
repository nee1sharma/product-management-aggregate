package com.sharma.nks.products.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

@Configuration
@ControllerAdvice
@ConditionalOnProperty("app.logging.request")
public class RequestLogger extends RequestBodyAdviceAdviceAdapter {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        RequestResponseLoggerHelper.logRequest(httpServletRequest, body);
        return super.afterBodyRead(body, httpInputMessage, methodParameter, type, aClass);
    }
}
