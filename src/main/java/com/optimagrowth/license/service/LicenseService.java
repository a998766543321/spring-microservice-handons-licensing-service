package com.optimagrowth.license.service;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.License;

@Service
public class LicenseService {

    @Autowired
    MessageSource messages;

    public License getLicense(String licenseId, String organizationId) {
        return License.builder()
                .id(new Random().nextInt(1000))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("Software product")
                .productName("Ostock")
                .licenseType("full")
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if(Objects.nonNull(license)) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if(Objects.nonNull(license)) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.update.message", null, null), license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
        return responseMessage;
    }

}
