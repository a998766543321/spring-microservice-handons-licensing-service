package com.optimagrowth.license.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LanguageConfig {
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        // localeResolver.setDefaultLocale(new Locale ( "es" , "ES" ));
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        // Doesn't throw an error if a message isn't found, instead it returns the message code
        messageSource.setUseCodeAsDefaultMessage(true);

        // Set the base name of the lanaguages properties files
        messageSource.setBasename("messages");
        
        return messageSource;
    }

}
