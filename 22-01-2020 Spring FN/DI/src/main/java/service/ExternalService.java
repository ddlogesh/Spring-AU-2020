package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Triangle;

@Service
public class ExternalService {
  
  @Autowired
  Triangle tr;

  public void printTriangle() {
    System.out.println(tr);
  }
}