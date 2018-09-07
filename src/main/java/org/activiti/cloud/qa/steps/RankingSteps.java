package org.activiti.cloud.qa.steps;

import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
