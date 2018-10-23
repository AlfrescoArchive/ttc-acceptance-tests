Meta:

Narrative:
As a user
I want to perform operations on process instances

Scenario: process a matching tweet
Given the user is authenticated as testuser
When a matching tweet is sent
Then the tweet should be in the list of the processed tweets

Scenario: process a non-matching tweet
Given the user is authenticated as testuser
When a non-matching tweet is sent
Then the tweet should be in the list of the discarded tweets

Scenario: ranking a tweet as positive
Given the user is authenticated as testuser
When a positive tweet is sent
Then the author should be in the list of authors ranked as positive

Scenario: ranking a tweet as neutral
Given the user is authenticated as testuser
When a neutral tweet is sent
Then the author should be in the list of authors ranked as neutral

Scenario: ranking a tweet as negative
Given the user is authenticated as testuser
When a negative tweet is sent
Then the author should be in the list of authors ranked as negative