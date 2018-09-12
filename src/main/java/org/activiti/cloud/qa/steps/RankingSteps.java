package org.activiti.cloud.qa.steps;

import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.model.RankedAuthor;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Reward steps
 */
@EnableRuntimeFeignContext
public class RankingSteps {

    @Autowired
    private RankingService rankingService;

    @Step
    public void checkServicesHealth() {
        assertThat(rankingService.isServiceUp()).isTrue();
    }

    @Step
    public List<RankedAuthor> getPositiveRanking(){
        return rankingService.getPositiveRankings();
    }

    @Step
    public List<RankedAuthor> getNeutralRanking(){
        return rankingService.getNeutralRankings();
    }

    @Step
    public List<RankedAuthor> getNegativeRanking(){
        return rankingService.getNegativeRankings();
    }

    @Step
    public void cleanRanking() {
        rankingService.cleanRankings();
    }
}
