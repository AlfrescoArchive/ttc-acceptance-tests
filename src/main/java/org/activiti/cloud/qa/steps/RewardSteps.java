package org.activiti.cloud.qa.steps;

import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Reward steps
 */
@EnableRuntimeFeignContext
public class RewardSteps {

    @Autowired
    private RewardService rewardService;

    @Step
    public void checkServicesHealth() {
        assertThat(rewardService.isServiceUp()).isTrue();
    }
}
