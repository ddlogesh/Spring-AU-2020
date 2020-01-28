package com.au.spring.realtime.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.au.spring.realtime.model.Seller;
import com.au.spring.realtime.rowMapperLambda.RowMapperLambda;

@Repository
public class SellerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public Seller getSellerById(Integer id) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", id);
		String query = "select * from seller where s_id=:id";
		return namedParameterJdbcTemplate.queryForObject(query, parameters, RowMapperLambda.sellerRowMapperLambda);
		//return jdbcTemplate.queryForObject("select * from seller where s_id=" + id, RowMapperLambda.sellerRowMapperLambda);
	}
	
	public List<Seller> getAllSellers() {
		return (List<Seller>) jdbcTemplate.query("select * from seller", RowMapperLambda.sellerRowMapperLambda);
	}
	
	public Map<Integer,Seller> getAllSellersMap() {
		List<Seller> list = jdbcTemplate.query("select * from seller", RowMapperLambda.sellerRowMapperLambda);
		Map<Integer,Seller> returnMap = new HashMap<Integer, Seller>();
		for (Seller s: list)
		    returnMap.put(s.getSellerId(), s);
		return returnMap;
	}
	
	public List<Seller> addSeller(Seller seller) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", seller.getSellerId())
				.addValue("name", seller.getSellerName())
				.addValue("rating", seller.getRating())
				.addValue("shopName", seller.getshopName());
		
		String query = "insert into seller(s_id, s_name, rating, shop_name) values(:id, :name, :rating, :shopName)";
		namedParameterJdbcTemplate.update(query, parameters);
		return getAllSellers();
	}
}
