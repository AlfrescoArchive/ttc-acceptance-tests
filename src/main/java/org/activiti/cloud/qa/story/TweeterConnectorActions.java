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

import net.thucydides.core.annotations.Steps;
import org.activiti.cloud.qa.model.Tweet;
import org.activiti.cloud.qa.steps.TweeterSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class TweeterConnectorActions {

    private static Tweet lastSentMatchingTweet;
    private static Tweet lastSentNonMatchingTweet;
    private static Tweet lastRankedTweet;

    @Steps
    private TweeterSteps tweeterSteps;

    @Given("the tweeter feed is enabled")
    public void tweeterFeedIsEnabled() {
        tweeterSteps.startFeed();
    }

    @When("a matching tweet is sent")
    public void matchingTweet() {
        lastSentMatchingTweet = new Tweet("And how good is Activiti Cloud looking? " + System.currentTimeMillis(),
                                          "peter",
                                          "en");
        tweeterSteps.tweet(lastSentMatchingTweet);
    }

    @When("a non-matching tweet is sent")
    public void nonMatchingTweet(){
        lastSentNonMatchingTweet = new Tweet("A day without sunshine is like, you know, night." + System.currentTimeMillis(),
                                             "paul",
                                             "en");
        tweeterSteps.tweet(lastSentNonMatchingTweet);
    }

    @When("a positive tweet is sent")
    public void tweetRankedAsPositive(){
        lastRankedTweet = new Tweet("A goal is a dream with a deadline... Also Activiti Cloud is great! " + System.currentTimeMillis(),
                                        "paul_good_mood",
                                        "en");
        tweeterSteps.tweet(lastRankedTweet);

    }

    @When("a neutral tweet is sent")
    public void tweetRankedAsNeutral(){
        lastRankedTweet = new Tweet("Does anyone know the guys behind Activiti?" + System.currentTimeMillis(),
                                        "paul_neutral_mood",
                                        "en");
        tweeterSteps.tweet(lastRankedTweet);

    }

    @When("a negative tweet is sent")
    public void tweetRankedAsNegative(){
        lastRankedTweet = new Tweet("It’s a shame that Activiti team is not comming this year" + System.currentTimeMillis(),
                                        "paul_bad_mood",
                                        "en");
        tweeterSteps.tweet(lastRankedTweet);

    }


    public static Tweet getLastSentMatchingTweet() {
        return lastSentMatchingTweet;
    }

    public static Tweet getLastSentNonMatchingTweet() {
        return lastSentNonMatchingTweet;
    }

    public static Tweet getLastRankedTweet() {
        return lastRankedTweet;
    }
}
