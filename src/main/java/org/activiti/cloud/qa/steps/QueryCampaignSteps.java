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

import java.util.List;

import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.model.Tweet;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

@EnableRuntimeFeignContext
public class QueryCampaignSteps {

    @Autowired
    private QueryService queryService;

    @Step
    public List<Tweet> getProcessedTweets() {
        return queryService.getProcessedTweets();
    }

    @Step
    public PagedResources<Resource<Tweet>> getDiscardedTweets() {
        return queryService.getDiscardedTweets();
    }
}
