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
import org.activiti.cloud.api.process.model.CloudProcessInstance;
import org.activiti.cloud.qa.steps.TTCRuntimeBundleSteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.hateoas.PagedResources;

import static org.assertj.core.api.Assertions.assertThat;

public class RuntimeBundleActions {

    @Steps
    private TTCRuntimeBundleSteps runtimeBundleSteps;

    private PagedResources<CloudProcessInstance> processInstances;

    @When("the user requests the list of active process instances")
    public void getProcessInstances() {
        processInstances = runtimeBundleSteps.getAllProcessInstancesAdmin();
    }

    @Then("there is at least one process instance")
    public void hasAtLeastOneProcessInstance() {
        assertThat(processInstances).isNotNull();
        assertThat(processInstances.getContent().size()).isGreaterThanOrEqualTo(1);
    }

}
