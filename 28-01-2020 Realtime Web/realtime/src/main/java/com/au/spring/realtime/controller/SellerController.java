package com.au.spring.realtime.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.spring.realtime.model.Seller;
import com.au.spring.realtime.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/{id}")
	public Seller getSellerById(@PathVariable("id") Integer id) {
		return sellerService.getSellerById(id);
	}
	
	@GetMapping("/list")
	public List<Seller> getAllSellers() {
		return sellerService.getAllSellers();
	}

	@GetMapping("/map")
	public Map<Integer, Seller> getAllSellersMap() {
		return sellerService.getAllSellersMap();
	}
	
	@PostMapping("/addSeller")
	public List<Seller> addSeller(@RequestBody Seller seller) {
		return sellerService.addSeller(seller);
	}
}