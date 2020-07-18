package com.couponly.server.model.responses;

import com.couponly.server.model.ApiQuery;
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
