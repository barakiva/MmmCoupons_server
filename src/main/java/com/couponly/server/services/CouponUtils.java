package com.couponly.server.services;

import com.couponly.server.model.Coupon;
import com.couponly.server.model.CouponBody;
import com.couponly.server.model.CouponDates;
import com.couponly.server.model.responses.Deal;

import java.util.List;

public class CouponUtils {
    public List<Coupon> dealsToCoupons() {
        return null;
    }
    public Coupon dealToCoupon(Deal deal) {
        CouponBody body = new CouponBody(deal.getTitle(), deal.getShortTitle(),
                deal.getDescription(), deal.getDescription());
        CouponDates dates = new CouponDates(deal.getCreatedAt(), deal.getUpdatedAt(), deal.getExpiresAt());
//        ???
        return null;
    }
}
