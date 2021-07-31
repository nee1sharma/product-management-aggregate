package com.sharma.nks.products.logging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServletServerHttpResponse;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class RequestResponseLoggerHelper {

    private static final Gson GSON = new Gson();//GsonBuilder().registerTypeAdapter(LocalDate.class,
    //(JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString(),
    // DateTimeFormatter.ISO_LOCAL_DATE)).create();
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggerHelper.class);

    private RequestResponseLoggerHelper() {
    }

    public static void logRequest(HttpServletRequest request, Object body) {
        String jsonBody = GSON.toJson(body);
        LOGGER.trace("Headers: {}", getHeaders(request));
        LOGGER.info("Rest request URL: {}, Method: {}, Body:\n{}", request.getRequestURL(), request.getMethod(), jsonBody);
    }

    public static void logResponse(ServletServerHttpResponse response, Object body) {
        String jsonBody = GSON.toJson(body);
        LOGGER.info("Rest response status code: {}, body:\n{}", response.getServletResponse().getStatus(), jsonBody);
    }

    private static String getHeaders(HttpServletRequest request) {
        return Collections.list(Optional.ofNullable(request.getHeaderNames()).orElse(Collections.emptyEnumeration()))
                .stream()
                .map(h -> h + " : " + request.getHeader(h))
                .collect(Collectors.joining("\n", "\n", ""));
    }
}
