Meta:

Narrative:
As a user
I want to perform operations on process instances

Scenario: process a matching tweet
Given any authenticated user
When a matching tweet is sent
Then the tweet should be in the list of the processed tweets

Scenario: process a non-matching tweet
Given any authenticated user
When a non-matching tweet is sent
Then the tweet should be in the list of the discarded tweets