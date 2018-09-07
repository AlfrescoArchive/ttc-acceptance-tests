package org.activiti.cloud.qa.service;

import feign.Headers;
import feign.RequestLine;
import org.activiti.cloud.qa.model.Reward;
import java.util.List;
import static org.activiti.cloud.qa.service.ProcessingService.campaignName;

/**
 * Reward service
 */
public interface RewardService extends BaseService {

    @RequestLine("GET /v1/rewards/" + campaignName)
    @Headers("Content-Type: application/json")
    List<Reward> getRewards();

    @RequestLine("DELETE /v1/rewards/" + campaignName)
    @Headers("Content-Type: application/json")
    void cleanRewards();
}
