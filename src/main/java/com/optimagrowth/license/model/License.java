package com.optimagrowth.license.model;

import org.springframework.hateoas.RepresentationModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class License extends RepresentationModel<License>{

    // RepresentationModel<License> gives us the ability to add links to the License model class.

    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}
