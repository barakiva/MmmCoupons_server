package com.couponly.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ApiQuery {
    private Long total;
    private Long page;
    private Long perPage;
    private Object query;
    private Object location;
    private Object radius;
    private Object online;
    private Object categorySlugs;
    private Object providerSlugs;
    private Object updatedAfter;
    private Object order;
}
