#Test case:
#1.	Go to https://www.webstaurantstore.com/
#2.	Search for 'stainless work table'.
#3.	Check the search result ensuring every product has the word 'Table' in its title.
#4.	Add the last of found items to Cart.
#5.	Empty Cart.

@test
Feature: Shopping Cart Checkout

  Scenario: User search for "stainless work table"
    Given User is on the Webstaurant Store Main Page
    When User search for 'stainless work table'
    And User check the search result ensuring every product has the word 'Table' in its title
    And User add last of found items to cart
    Then User Empty Cart