package com.au.spring.realtime.rowMapperLambda;

import org.springframework.jdbc.core.RowMapper;

import com.au.spring.realtime.model.Seller;

public class RowMapperLambda {
	public static final RowMapper<Seller> sellerRowMapperLambda = (rs, rownum) -> {
		Seller seller = new Seller();
		seller.setSellerId(rs.getInt("s_id"));
		seller.setSellerName(rs.getString("s_name"));
		seller.setRating(rs.getDouble("rating"));
		seller.setshopName(rs.getString("shop_name"));
		return seller;
	};
}
