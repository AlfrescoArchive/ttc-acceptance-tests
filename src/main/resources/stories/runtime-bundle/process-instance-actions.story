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

Scenario: ranking a tweet as positive
Given any authenticated user
When a positive tweet is sent
Then the author should be in the list of authors ranked as positive

Scenario: ranking a tweet as neutral
Given any authenticated user
When a neutral tweet is sent
Then the author should be in the list of authors ranked as neutral

Scenario: ranking a tweet as negative
Given any authenticated user
When a negative tweet is sent
Then the author should be in the list of authors ranked as negative