Feature: Add items to wishlist

  Scenario Outline: validate wishlist shows added search results with specific text
    Given the user enters into bunnings site
    And enter text "<name>" to search for items
    And search for items
    When the search results show required items
    And the user adds to wishlist
    Then the wishlist shows added item

    Examples: 
      | name  |
      | Paint |