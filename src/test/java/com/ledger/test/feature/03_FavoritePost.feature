Feature: This feature is to test the Favorite Post functionality

@favpost @e2e
  Scenario: Fevorite a Post
    When user click on profile
    # Title - auto will create a dynamic Title as "Post with current date time stamp to avoid duplicates. Other than that it will enter the same text as mentioned.
    And user click on heart icon of "auto" post
    Then verify the count shows as "1" for post "auto"
    When user click on Favorited Articles
    Then verify "auto" post displayed in the list
