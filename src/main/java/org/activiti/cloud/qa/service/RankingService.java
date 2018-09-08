package org.activiti.cloud.qa.service;

import feign.Headers;
import feign.RequestLine;
import org.activiti.cloud.qa.model.RankedAuthor;
import org.activiti.cloud.qa.rest.feign.EnableRuntimeFeignContext;

import static org.activiti.cloud.qa.service.ProcessingService.campaignName;
import java.util.List;

/**
 * Reward service
 */
@EnableRuntimeFeignContext
public interface RankingService extends BaseService {

    @RequestLine("GET /v1/rank/" + campaignName + "/positive")
    @Headers("Content-Type: application/json")
    List<RankedAuthor> getPositiveRankings();

    @RequestLine("GET /v1/rank/" + campaignName + "/neutral")
    @Headers("Content-Type: application/json")
    List<RankedAuthor> getNeutralRankings();

    @RequestLine("GET /v1/rank/" + campaignName + "/negative")
    @Headers("Content-Type: application/json")
    List<RankedAuthor> getNegativeRankings();

    @RequestLine("DELETE /v1/rank/" + campaignName)
    @Headers("Content-Type: application/json")
    List<RankedAuthor> cleanRankings();

}
