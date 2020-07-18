package com.couponly.server.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable @Getter @Setter @AllArgsConstructor
public class CouponBody {
    private String title;
    @SerializedName("short_title")
    private String shortTitle;
    private String description;
    @SerializedName("fine_print")
    private String finePrint;
}
