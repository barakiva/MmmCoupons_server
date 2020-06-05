package com.couponly.server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter @NoArgsConstructor
public class RawResponse {
    private ApiQuery query;
    private List<DealWrapper> deals = new ArrayList<>();
}
