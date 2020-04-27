package com.capg.placeorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.placeorder.exception.ResourceNotFoundException;
import com.capg.placeorder.model.Product;
import com.capg.placeorder.repository.ProductRepository;

//@CrossOrigin(origins = {"http://localhost:4200"},methods = {
//		RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT
//})
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
    private ProductRepository productRepository;
	
	@GetMapping("/products")
    public List<Product> getAllEmployees() {
        return productRepository.findAll();
    }
	
	@GetMapping("/products/{orderId}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "orderId") Long productId)
    		throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }
	
	@PostMapping("/products")
    public Product createEmployee(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
	
	@PutMapping("/products/{orderId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "orderId") Long productId,
         @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setQuantityUnit(productDetails.getQuantityUnit());
        product.setDateOfDelivery(productDetails.getDateOfDelivery());
        product.setDeliveryStatus(productDetails.getDeliveryStatus());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
        
//          employee.setEmailId(employeeDetails.getEmailId());
//          employee.setLastName(employeeDetails.getLastName());
//          employee.setFirstName(employeeDetails.getFirstName());
//          final Employee updatedEmployee = employeeRepository.save(employee);
//         return ResponseEntity.ok(updatedEmployee);
        
    }
	
	@DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
         throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
