package edu.bjtu.microservice.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import edu.bjtu.microservice.product.entity.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "jpa")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
