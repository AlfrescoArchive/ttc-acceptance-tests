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

package org.activiti.cloud.qa;

import org.activiti.cloud.acc.shared.config.BaseTestsConfigurationProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * Config properties
 */
@Configuration
@Import(BaseTestsConfigurationProperties.class)
@Primary
@PropertySource("classpath:config-${profile:env}.properties")
public class TTCTestsConfigurationProperties {

    @Value("${twitter.connector.url}")
    private String twitterConnectorUrl;

    @Value("${reward.connector.url}")
    private String rewardConnectorUrl;

    @Value("${ranking.connector.url}")
    private String rankingConnectorUrl;

    @Value("${processing.connector.url}")
    private String processingConnectorUrl;

    @Value("${runtime.bundle.url}")
    private String runtimeBundleUrl;

    @Value("${query.url}")
    private String queryUrl;

    @Value("${gateway.url}")
    private String gatewayUrl;

    public String getTwitterConnectorUrl() {
        return twitterConnectorUrl;
    }

    public String getRewardConnectorUrl() {
        return rewardConnectorUrl;
    }

    public String getRankingConnectorUrl() {
        return rankingConnectorUrl;
    }

    public String getProcessingConnectorUrl() {
        return processingConnectorUrl;
    }

    public String getRuntimeBundleUrl() {
        return runtimeBundleUrl;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public String getCloudGatewayUrl() {
        return gatewayUrl;
    }

}
