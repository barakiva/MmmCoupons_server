package com.couponly.server.model.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "deals")
public class Deal {
    @Id
    private Long id;
    private String title;
    @SerializedName("short_title")
    private String shortTitle;
    private String description;
    @SerializedName("fine_print")
    private String finePrint;
    private String url;
    private Double price;
    private Double value;
    @SerializedName("discount_amount")
    private Double discountAmount;
    @SerializedName("discount_percentage")
    private Double discountPercentage;
    @SerializedName("provider_name")
    private String providerName;
    @SerializedName("provider_slug")
    private String providerSlug;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_slug")
    private String categorySlug;
    @SerializedName("image_url")
    private String imageUrl;
    private Boolean online;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("expires_at")
    private String expiresAt;
    @ManyToOne()
    private Merchant merchant;
    @SerializedName("number_sold")
    private Long numberSold;
}
