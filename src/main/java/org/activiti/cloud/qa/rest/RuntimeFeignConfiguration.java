/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.jackson.JacksonEncoder;
import org.activiti.cloud.api.model.shared.impl.conf.CloudCommonModelAutoConfiguration;
import org.activiti.cloud.api.process.model.impl.conf.CloudProcessModelAutoConfiguration;
import org.activiti.cloud.qa.TTCTestsConfigurationProperties;
import org.activiti.cloud.qa.rest.feign.FeignConfiguration;
import org.activiti.cloud.qa.rest.feign.FeignRestDataClient;
import org.activiti.cloud.qa.rest.feign.HalDecoder;
import org.activiti.cloud.qa.service.CloudGatewayService;
import org.activiti.cloud.qa.service.QueryService;
import org.activiti.cloud.qa.service.RuntimeBundleService;
import org.activiti.cloud.qa.service.TweeterConnectorService;
import org.activiti.cloud.qa.service.ProcessingService;
import org.activiti.cloud.qa.service.RewardService;
import org.activiti.cloud.qa.service.RankingService;
import org.activiti.runtime.conf.CommonModelAutoConfiguration;
import org.conf.activiti.runtime.ProcessModelAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Feign Configuration
 */
@Configuration
@Import({JacksonAutoConfiguration.class,
        FeignConfiguration.class,
        CloudCommonModelAutoConfiguration.class,
        CloudProcessModelAutoConfiguration.class,
        CommonModelAutoConfiguration.class,
        ProcessModelAutoConfiguration.class})
public class RuntimeFeignConfiguration {

    private final TTCTestsConfigurationProperties runtimeTestsConfigurationProperties;

    private final ObjectMapper objectMapper;

    public RuntimeFeignConfiguration(TTCTestsConfigurationProperties runtimeTestsConfigurationProperties,
                                     ObjectMapper objectMapper) {
        this.runtimeTestsConfigurationProperties = runtimeTestsConfigurationProperties;
        this.objectMapper = objectMapper;
    }

    @Bean
    public RuntimeBundleService runtimeBundleService() {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                         new HalDecoder(objectMapper))
                .target(RuntimeBundleService.class,
                        runtimeTestsConfigurationProperties.getRuntimeBundleUrl());
    }

    @Bean
    public QueryService queryService() {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                         new HalDecoder(objectMapper))
                .target(QueryService.class,
                        runtimeTestsConfigurationProperties.getQueryUrl());
    }

    @Bean
    public TweeterConnectorService tweeterConnectorService() {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                         new HalDecoder(objectMapper))
                .target(TweeterConnectorService.class,
                        runtimeTestsConfigurationProperties.getTwitterConnectorUrl());
    }

    @Bean
    public CloudGatewayService cloudGatewayService () {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                        new HalDecoder(objectMapper))
                .target(CloudGatewayService.class,
                        runtimeTestsConfigurationProperties.getCloudGatewayUrl());

    }

    @Bean
    public ProcessingService processingService () {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                        new HalDecoder(objectMapper))
                .target(ProcessingService.class,
                        runtimeTestsConfigurationProperties.getProcessingConnectorUrl());

    }

    @Bean
    public RewardService rewardService () {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                        new HalDecoder(objectMapper))
                .target(RewardService.class,
                        runtimeTestsConfigurationProperties.getRewardConnectorUrl());

    }

    @Bean
    public RankingService rankingService () {
        return FeignRestDataClient
                .builder(new JacksonEncoder(objectMapper),
                        new HalDecoder(objectMapper))
                .target(RankingService.class,
                        runtimeTestsConfigurationProperties.getRankingConnectorUrl());

    }


}
