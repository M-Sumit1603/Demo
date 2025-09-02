Feature: Posts API Testing

  Scenario: Retrieve all posts
    Given I send a GET request to "/posts"
    Then the response status code should be 200
    And the response should contain 100 posts


  Scenario: Retrieve a specific post by ID
    Given I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response should contain the post with id 1

  Scenario: Create a new post
    Given I send a POST request to "/posts" with body:
      """
      {
        "userId": 1,
        "title": "My New Post",
        "body": "This is a test post"
      }
      """
    Then the response status code should be 201
    And the response should contain the new post with userId 1

  Scenario: Update an existing post by ID
    Given I send a PUT request to "/posts/1" with body:
      """
      {
        "id": 1,
        "userId": 1,
        "title": "Updated Post Title",
        "body": "Updated post body"
      }
      """
    Then the response status code should be 200
    And the response should reflect the updated title "Updated Post Title"

    Scenario: Delete a specific post by ID
      Given I send a DELETE request to "/posts/1"
      Then the response status code should be 200

  Scenario: Partially update a post title by ID
    Given I send a PATCH request to "/posts/1" with body:
      """
      {
        "title": "Partially Updated Title"
      }
      """
    Then the response status code should be 200
    And the response should reflect the updated title "Partially Updated Title"


