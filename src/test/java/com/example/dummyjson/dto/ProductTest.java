package com.example.dummyjson.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    @Test
    public void testGetAndSetter(){
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        // Ajustado por conta do método New Double por estar marcado como depreciado desde o Java 9
        Double expectedPrice = Double.valueOf("2.1");

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("A dummy title");
        product1.setDescription("A dummy description");
        // Ajustado por conta do método New Double por estar marcado como depreciado desde o Java 9
        product1.setPrice(Double.valueOf("2.1"));

        Assert.assertEquals(expectId, product1.getId());
        Assert.assertEquals(expectedTitle, product1.getTitle());
        Assert.assertEquals(expectedDescription, product1.getDescription());
        Assert.assertEquals(expectedPrice, product1.getPrice());
    }
}
