package org.activiti.cloud.qa.model;

import java.util.Date;

public class Reward {

    private String campaignName;
    private RankedAuthor rankedAuthor;
    private String rewardsText;
    private Date rewardDate;

    public Reward() {
    }

    public Reward(String campaignName,
                  RankedAuthor rankedAuthor,
                  String rewardsText,
                  Date rewardDate) {
        this.campaignName = campaignName;
        this.rankedAuthor = rankedAuthor;
        this.rewardsText = rewardsText;
        this.rewardDate = rewardDate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public RankedAuthor getRankedAuthor() {
        return rankedAuthor;
    }

    public String getRewardsText() {
        return rewardsText;
    }

    public Date getRewardDate() {
        return rewardDate;
    }
}