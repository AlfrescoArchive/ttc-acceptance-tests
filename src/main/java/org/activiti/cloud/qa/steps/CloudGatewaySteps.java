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

package org.activiti.cloud.qa.steps;


import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.CloudGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Cloud Gateway steps
 */
@EnableRuntimeFeignContext
public class CloudGatewaySteps {

    @Autowired
    private CloudGatewayService cloudGatewayService;

    @Step
    public void checkServicesHealth() {
        assertThat(cloudGatewayService.isServiceUp()).isTrue();
    }

    @Step
    public void refresh(){
        assertThat(cloudGatewayService.refresh().getStatusCode().is2xxSuccessful());
    }

}
