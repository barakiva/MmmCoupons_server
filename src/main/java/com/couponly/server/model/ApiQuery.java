package com.couponly.server.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ApiQuery {
    private Long total;
    private Long page;
    @SerializedName("per_page")
    private Long perPage;
    private Object query;
    private Object location;
    private Object radius;
    private Object online;
    @SerializedName("category_slugs")
    private Object categorySlugs;
    @SerializedName("provider_slugs")
    private Object providerSlugs;
    @SerializedName("updated_after")
    private Object updatedAfter;
    private Object order;
}
