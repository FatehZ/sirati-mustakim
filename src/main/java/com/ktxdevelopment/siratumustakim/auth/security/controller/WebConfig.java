package com.ktxdevelopment.siratumustakim.auth.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customResponseModelHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }

    @Bean
    public CustomResponseModelHttpMessageConverter customResponseModelHttpMessageConverter() {
        return new CustomResponseModelHttpMessageConverter();
    }

    public class CustomResponseModelHttpMessageConverter extends AbstractHttpMessageConverter<CustomResponseModel<?>> {

        public CustomResponseModelHttpMessageConverter() {
            super(MediaType.APPLICATION_JSON);
        }

        @Override
        protected boolean supports(@NotNull Class<?> clazz) {
            return CustomResponseModel.class.isAssignableFrom(clazz);
        }

        @NotNull
        @Override
        protected CustomResponseModel<?> readInternal(@NotNull Class<? extends CustomResponseModel<?>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
            return objectMapper.readValue(inputMessage.getBody(), clazz);
        }

        @Override
        protected void writeInternal(@NotNull CustomResponseModel<?> customResponseModel, HttpOutputMessage outputMessage)
                throws IOException, HttpMessageNotWritableException {
            objectMapper.writeValue(outputMessage.getBody(), customResponseModel);
        }

        @NotNull
        @Override
        public List<MediaType> getSupportedMediaTypes(@NotNull Class<?> clazz) {
            return super.getSupportedMediaTypes(clazz);
        }
    }
}