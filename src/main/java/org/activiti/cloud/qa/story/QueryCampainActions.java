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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.thucydides.core.annotations.Steps;
import org.activiti.cloud.qa.model.Tweet;
import org.activiti.cloud.qa.steps.QueryCampaignSteps;
import org.jbehave.core.annotations.Then;
import org.springframework.hateoas.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class QueryCampainActions {

    @Steps
    private QueryCampaignSteps queryCampaignSteps;

    @Then("the tweet should be in the list of the processed tweets")
    public void theMatchingTweetIsInTheList() {
        await().untilAsserted(() -> {
            Collection<Resource<Tweet>> matchingTweetsRaw = queryCampaignSteps.getProcessedTweets().getContent().;
            assertThat(matchingTweetsRaw).isNotNull();

            List<Tweet> matchingTweets = new ArrayList<>();
            for( Resource<Tweet> resource: matchingTweetsRaw){
                matchingTweets.add(resource.getContent());
            }

            assertThat(matchingTweets)
                    .extracting(Tweet::getText)
                    .contains(TweeterConnectorActions.getLastSentMatchingTweet().getText());
        });
    }

    @Then("the tweet should be in the list of the discarded tweets")
    public void theDiscardeTweetIsInTheList(){
        await().untilAsserted(() -> {
            Collection<Resource<Tweet>> discardedTweetsRaw = queryCampaignSteps.getDiscardedTweets().getContent();
            assertThat(discardedTweetsRaw).isNotNull();

            List<Tweet> discardedTweets = new ArrayList<>();
            for( Resource<Tweet> resource: discardedTweetsRaw){
                discardedTweets.add(resource.getContent());
            }

            assertThat(discardedTweets)
                    .extracting(Tweet::getText)
                    .contains(TweeterConnectorActions.getLastSentNonMatchingTweet().getText());

        });
    }

}
