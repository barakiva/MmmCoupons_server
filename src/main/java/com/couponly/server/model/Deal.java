package com.couponly.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Deal {
    private Long id;
    private String title;
    private String shortTitle;
    private String description;
    private String finePrint;
    private String url;
    private Double price;
    private Double value;
    private Double discountAmount;
    private Double discountPercentage;
    private String providerName;
    private String providerSlug;
    private String categoryName;
    private String categorySlug;
    private String imageUrl;
    private Boolean online;
    private String createdAt;
    private String updatedAt;
    private Merchant merchant;
    private Long numberSold;
    private String expiresAt;
}
