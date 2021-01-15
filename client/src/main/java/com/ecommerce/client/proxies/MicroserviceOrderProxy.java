package com.ecommerce.client.proxies;

import com.ecommerce.client.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
public interface MicroserviceOrderProxy {
    @PostMapping(value = "/microservice-order/order")
    OrderDTO addOrder(@RequestBody OrderDTO order);
}
