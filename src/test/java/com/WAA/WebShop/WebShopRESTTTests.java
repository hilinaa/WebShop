package com.WAA.WebShop;

import com.WAA.WebShop.service.ProductDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
class WebShopRESTTTests {

	@BeforeClass
	public static void setup(){
		RestAssured.port =Integer.valueOf(8080);
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "";
	}
	@Test
	public void testGetAllProducts() {
		ProductDTO product1 = new ProductDTO("0002","Screen",200,1);
		ProductDTO product2 = new ProductDTO("0003","Phone",100,2);
	//Add products to test
		given()
				.contentType("application/json")
				.body(product1)
				.when().post("/products").then()
				.statusCode(200);
		given()
				.contentType("application/json")
				.body(product2)
				.when().post("/products").then()
				.statusCode(200);

		//Get all products and verify
		given().when().get("products").then().statusCode(200)
				.and()
				.body("products.productNumber",hasItems("0002","0003"))
				.body("products.name",hasItems("Phone","Screen"))
				.body("products.price",hasItems(100f,200f))
				.body("products.numberInStock",hasItems(1,2));

		//CleanUp
		given().when().delete("products/0002");
		given().when().delete("/products/0003");

	}
	@Test
	public void testGetOneProduct() {
		ProductDTO product = new ProductDTO("0002","Screen",200,1);

		given().contentType("application/json")
			.body(product)
			.when().post("/products").then()
			.statusCode(200);

		given().when().get("/products/0002")
				.then().statusCode(200)
				.and()
				.body("productNumber",equalTo("0002"))
				.body("name",equalTo("Screen"))
				.body("price",equalTo(200f))
				.body("numberInStock",equalTo(1));

		given().when().delete("/products/0002");

	}
	@Test
	public void testDeleteProduct() {
		ProductDTO product = new ProductDTO("0002","Screen",200,1);

		given().contentType("application/json")
				.body(product)
				.when().post("/products").then()
				.statusCode(200);

		given().when().delete("/products/0002");

		given().when().get("/products/0002").then()
				.statusCode(404)
				.and().body("errorMessage",equalTo("Product with product number 0002 is not available"));
	}
	@Test
	public void testUpdateProduct() {
		ProductDTO product = new ProductDTO("0002","Screen",200,1);
		ProductDTO UpdatedProduct = new ProductDTO("0002","Screen",250,1);

		given()
				.contentType("application/json")
				.body(product)
				.when().post("/products").then()
				.statusCode(200);
		//update
		given()
				.contentType("application/json")
				.body(UpdatedProduct)
				.when().put("/products/0002").then()
				.statusCode(200);
		// get the product and verify
		given()
				.when()
				.get("products/0002")
				.then()
				.statusCode(200)
				.and()
				.body("productNumber",equalTo("0002"))
				.body("name",equalTo("Screen"))
				.body("price",equalTo(250f))
				.body("numberInStock",equalTo(1));
		//cleanup
		given()
				.when()
				.delete("products/0002");
	}
	@Test
	public void testAddProduct() {
		ProductDTO product = new ProductDTO("0002","Screen",200,1);

		given()
				.contentType("application/json")
				.body(product)
				.when().post("/products").then()
				.statusCode(200);
		// get the product and verify
		given()
				.when()
				.get("products/0002")
				.then()
				.statusCode(200)
				.and()
				.body("productNumber",equalTo("0002"))
				.body("name",equalTo("Screen"))
				.body("price",equalTo(200f))
				.body("numberInStock",equalTo(1));
		//cleanup
		given()
				.when()
				.delete("products/0002");
	}
	@Test
	public void testSearchProduct() {
		ProductDTO product1 = new ProductDTO("0002","Screen",200,1);
		ProductDTO product2 = new ProductDTO("0003","Phone",100,2);
		//Add products to test
		given()
				.contentType("application/json")
				.body(product1)
				.when().post("/products").then()
				.statusCode(200);
		given()
				.contentType("application/json")
				.body(product2)
				.when().post("/products").then()
				.statusCode(200);

		//Get all products and verify
		given().when().get("products?name=Scre").then().statusCode(200)
				.and()
				.body("products.productNumber",hasItems("0002"))
				.body("products.name",hasItems("Screen"))
				.body("products.price",hasItems(200f))
				.body("products.numberInStock",hasItems(1));

		given().when().get("products?name=Phon").then().statusCode(200)
				.and()
				.body("products.productNumber",hasItems("0003"))
				.body("products.name",hasItems("Phone"))
				.body("products.price",hasItems(100f))
				.body("products.numberInStock",hasItems(2));

		//CleanUp
		given().when().delete("/products/0002");
		given().when().delete("/products/0003");

	}

}
