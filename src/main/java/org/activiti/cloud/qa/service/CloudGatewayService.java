package org.activiti.cloud.qa.service;

import feign.Headers;
import feign.RequestLine;
import org.springframework.http.ResponseEntity;

/**
 * Cloud Gateway service
 */
public interface CloudGatewayService extends BaseService {

    @RequestLine("POST /actuator/refresh")
    @Headers("Content-Type: application/json")
    ResponseEntity refresh();



}
