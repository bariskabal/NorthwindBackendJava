package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	public ProductsController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return productService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return productService.add(product);
	}
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return productService.getByProductNameAndCategoryId(productName,categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return productService.getByProductNameContains(productName);
	}
	@GetMapping("/getallbypage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		return productService.getAll(pageNo,pageSize);
	}
	@GetMapping("/getalldesc")
	public DataResult<List<Product>> getAllSorted(){
		return productService.getAllSorted();
	}
	@GetMapping("/getproductwithcategorydetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return productService.getProductWithCategoryDetails();
	}
}
