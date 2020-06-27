//package com.user.household;
//
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.junit.Assert.assertNotNull;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = HouseHoldApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class HouseHoldApplicationIntegrationTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @LocalServerPort
//    private int port;
//
//    private String getRootUrl() {
//        return "http://localhost:" + port;
//    }
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Test
//    public void testGetAllAppliances() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/getList",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//
//    @Test
//    public void testSearchApplianceById() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testSearchApplianceByFilters() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/search",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testCreateAppliance() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/create",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testUpdateAppliance() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/update/",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testDeleteAppliance() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/appliances/delete/",
//                HttpMethod.GET, entity, String.class);
//        System.out.println(response.getBody());
//        assertNotNull(response.getBody());
//    }
//
//}