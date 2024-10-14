package com.example.dummyjson.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WebClientConfigTest {

    @InjectMocks
    WebClientConfig webClientConfig;

    @Test
    public void testWebClientConfig(){
        Assert.assertNotNull(this.webClientConfig.createWebClient());
    }
}
