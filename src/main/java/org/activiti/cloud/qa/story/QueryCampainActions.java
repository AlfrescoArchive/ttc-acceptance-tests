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

package org.activiti.cloud.qa.story;

import java.util.List;

import net.thucydides.core.annotations.Steps;
import org.activiti.cloud.qa.model.Tweet;
import org.activiti.cloud.qa.steps.QueryCampaignSteps;
import org.activiti.cloud.qa.steps.TweeterSteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryCampainActions {

    @Steps
    private QueryCampaignSteps queryCampaignSteps;

    @Steps
    private TweeterSteps tweeterSteps;

    private List<Tweet> matchingTweets;

    private PagedResources<Resource<Tweet>> discardedTweets;

    @When("the user asks for matching tweets")
    public void getMatchingTweets(){
        matchingTweets = queryCampaignSteps.getProcessedTweets();
    }

    @Then("there is at least one matching tweet")
    public void hasMatchingTweet(){
        assertThat(matchingTweets).isNotNull();
        assertThat(matchingTweets.size()).isGreaterThanOrEqualTo(1);
    }

    @When("the user asks for discarded tweets")
    public void getDiscardedTweets() {
        discardedTweets = queryCampaignSteps.getDiscardedTweets();
    }

    @Then("there is at least one discarded tweet")
    public void hasDiscardedTweet(){
        assertThat(discardedTweets).isNotNull();
        assertThat(discardedTweets.getContent().size()).isGreaterThanOrEqualTo(1);
    }

}
