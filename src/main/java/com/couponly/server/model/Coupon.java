package com.couponly.server.model;

import com.couponly.server.model.responses.Merchant;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Getter @Setter @NoArgsConstructor
//@Entity @Table(name = "coupons")
public class Coupon {
    @Id
    private Long id;
    private CouponBody couponBody;
    private Double price;
    private Double value;
    private String url;
    @SerializedName("provider_name")
    private String providerName;
    @SerializedName("provider_slug")
    private String providerSlug;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_slug")
    private String categorySlug;
    private String imageUrl;
    private Boolean online;
    private CouponDates couponDates;
    @ManyToOne()
    private Merchant merchant;
    @SerializedName("number_sold")
    private Long numberSold;
}
