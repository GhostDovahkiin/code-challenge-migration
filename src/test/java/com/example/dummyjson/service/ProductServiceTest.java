package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private static ProductService productService;
    private static MockWebServer mockWebServer;

    @Before
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        WebClient webClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/").toString())
                .build();

        productService = new ProductService(webClient);
    }

    @After
    public void tearDown() throws IOException{
        mockWebServer.close();
    }

    @Test
    public void testGetAllProducts() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(getAllMockResponse()));

        List<Product> result = productService.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("EssenceMascaraLashPrincess", result.get(0).getTitle());
        assertEquals("EyeshadowPalettewithMirror", result.get(1).getTitle());
    }

    @Test
    public void testGetProductById() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setBody(getOneMockResponse()));

        Product result = productService.getProductById(1L);

        assertEquals("EssenceMascaraLashPrincess", result.getTitle());
    }

    private String getAllMockResponse() {
        return "{\"products\":[{\"id\":1,\"title\":\"EssenceMascaraLashPrincess\",\"price\":9.99},{\"id\":2,\"title\":\"EyeshadowPalettewithMirror\",\"price\":12.50}]}";
    }

    private String getOneMockResponse() {
        return "{\"id\":1,\"title\":\"EssenceMascaraLashPrincess\",\"price\":9.99}";
    }
}
