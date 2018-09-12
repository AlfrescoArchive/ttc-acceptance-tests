package org.activiti.cloud.qa.story;

import net.thucydides.core.annotations.Steps;
import org.activiti.cloud.qa.model.RankedAuthor;
import org.activiti.cloud.qa.model.Tweet;
import org.activiti.cloud.qa.steps.RankingSteps;
import org.jbehave.core.annotations.Then;
import org.springframework.hateoas.Resource;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class RankingActions {

    @Steps
    private RankingSteps rankingSteps;

    @Then("the author should be in the list of authors ranked as positive")
    public void theAuthorIsInThePositiveList(){
        await().untilAsserted(() -> {

            List<RankedAuthor> positiveRanking = rankingSteps.getPositiveRanking();
            assertThat(positiveRanking).isNotNull();
            assertThat(positiveRanking)
                    .extracting(RankedAuthor::getUserName)
                    .contains(TweeterConnectorActions.getLastRankedTweet().getAuthor());


        });
    }

    @Then("the author should be in the list of authors ranked as neutral")
    public void theAuthorIsInTheNeutralList(){
        await().untilAsserted(() -> {

            List<RankedAuthor> neutralRanking = rankingSteps.getNeutralRanking();
            assertThat(neutralRanking).isNotNull();
            assertThat(neutralRanking)
                    .extracting(RankedAuthor::getUserName)
                    .contains(TweeterConnectorActions.getLastRankedTweet().getAuthor());


        });
    }

    @Then("the author should be in the list of authors ranked as negative")
    public void theAuthorIsInTheNegativeList(){
        await().untilAsserted(() -> {

            List<RankedAuthor> negativeRanking = rankingSteps.getNegativeRanking();
            assertThat(negativeRanking).isNotNull();
            assertThat(negativeRanking)
                    .extracting(RankedAuthor::getUserName)
                    .contains(TweeterConnectorActions.getLastRankedTweet().getAuthor());


        });
    }






}
