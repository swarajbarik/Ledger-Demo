Feature: This feature is to test the Add Post functionality

@addpost @e2e
  Scenario: Add Post
    When user click on "New Post" link from top menu
    And user enters the article details as below
      # Title - auto will create a dynamic Title as "Post with current date time stamp to avoid duplicates. Other than that it will enter the same text as mentioned.
      | Title | About           | Description                                  | Tags       |
      | auto  | Automation Post | This is to test the add post from automation | automation |
    And user click on Publish Article button
    Then verify the post title should display in header
