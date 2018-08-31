Meta:

Narrative:
As a user
I want to perform operations on process instances

Scenario: get matching tweets
Given the user is authenticated as an hradmin
And the tweeter feed is enabled
When the user asks for matching tweets
Then there is at least one matching tweet

Scenario: get discarded tweets
Given the user is authenticated as an hradmin
And the tweeter feed is enabled
When the user asks for discarded tweets
Then there is at least one discarded tweet