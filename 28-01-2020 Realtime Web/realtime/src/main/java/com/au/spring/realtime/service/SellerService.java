package com.au.spring.realtime.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.realtime.dao.SellerDAO;
import com.au.spring.realtime.model.Seller;

@Service
public class SellerService {
	
	@Autowired
	SellerDAO sellerDAO;
	
	public Seller getSellerById(Integer id) {
		return sellerDAO.getSellerById(id);
	}
	
	public List<Seller> getAllSellers() {
		return sellerDAO.getAllSellers();
	}
	
	public Map<Integer,Seller> getAllSellersMap() {
		return sellerDAO.getAllSellersMap();
	}
	
	public List<Seller> addSeller(Seller seller) {
		return sellerDAO.addSeller(seller);
	}
}
