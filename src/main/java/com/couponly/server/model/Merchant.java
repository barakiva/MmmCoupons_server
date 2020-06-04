package com.couponly.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Merchant {
    private Long id;
    private String name;
    private String address;
    private String region;
    private String country;
    private Double latitude;
    private Double longitude;
}
