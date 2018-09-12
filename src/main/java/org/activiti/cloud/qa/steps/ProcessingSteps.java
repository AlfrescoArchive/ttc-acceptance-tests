package org.activiti.cloud.qa.steps;

import net.thucydides.core.annotations.Step;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;
import org.activiti.cloud.qa.service.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;



/**
 * Processing steps
 */
@EnableRuntimeFeignContext
public class ProcessingSteps {

    @Autowired
    private ProcessingService processingService;

    @Step
    public void checkServicesHealth() {
        assertThat(processingService.isServiceUp()).isTrue();
    }
}
