Feature: Product

  Scenario: Post product with valid data
    Given Post product with json "PostProductValid.json"
    When Send request post product
    Then Status code should be 200
    And Response body message was "success insert product"
    And Validate json schema "PostProductValidSchema.json"

  Scenario: Get list product sales
    Given Get list product sales
    When Send request get product sales
    Then Status code should be 200
    And Response body message was "success read products."

  Scenario: Get all products
    Given Get all products
    When Send request get all products
    Then Status code should be 200
    And Response body message was "success read products."

  Scenario Outline: Get product with valid parameter
    Given Get product with parameter "<parameter>"
    When Send request get product with parameter
    Then Status code should be 200
    And Response body message was "success reading products."
    And Response body data category was "<parameter>"
    Examples:
      | parameter |
      | Baju      |

  Scenario Outline: Get product with unavailable parameter
    Given Get product with parameter "<parameter>"
    When Send request get product with parameter
    Then Status code should be 200
    And Response body message was "success reading products."
    And Validate json schema "GetProductUnavailableParamSchema.json"
    Examples:
      | parameter |
      | abcde     |

  Scenario Outline: Get product with valid product id
    Given Product with id <id>
    When Send request get product with id
    Then Status code should be 200
    And Response body message was "success read product."
    And Response body data id was <id>
    And Validate json schema "GetProductWithValidIDSchema.json"
    Examples:
      | id |
      | 3  |

  Scenario Outline: Get product with unavailable product id
    Given Product with id <id>
    When Send request get product with id
    Then Status code should be 404
    Examples:
      | id  |
      | 100 |

  Scenario Outline: Get product with invalid product id
    Given Get product with invalid id "<id>"
    When Send request get product with id
    Then Status code should be 400
    And Response body message was "error. id should be number"
    And Validate json schema "GetProductInvalidIDSchema.json"
    Examples:
      | id    |
      | abcde |

  Scenario Outline: Update product data with valid product id
    Given Update product data with product id <id> and json "<json>"
    When Send request put product data
    Then Status code should be 200
    And Response body message was "success update data"
    And Validate json schema "UpdateProductValidSchema.json"
    Examples:
      | id | json                      |
      | 13 | UpdateProductValidID.json |

  Scenario Outline: Post image with valid product id
    Given Product with id <id> and image "<image>"
    When Send request post image
    Then Status code should be 200
    And Response body message was "success post image data"
    And Validate json schema "PostImageValidSchema.json"
    Examples:
      | id | image          |
      | 13 | airjordan3.jpg |

#  Scenario Outline: Delete image with valid product id and image id
#    Given Product with id <product_id> and image with id <image_id>
#    When Send request delete image
#    Then Status code should be 200
#    And Response body message was "success delete image data"
#    And Validate json schema "DeleteImageValidSchema.json"
#    Examples:
#      | product_id | image_id |
#      | 13         | 19       |

#  Scenario Outline: Delete product with valid product id
#    Given Product with id <id>
#    When Send request delete product
#    Then Status code should be 200
#    And Response body message was "success delete data"
#    And Validate json schema "DeleteProductSchema.json"
#    Examples:
#      | id |
#      | 13 |

  Scenario Outline: Delete product with product id not belong to the user
    Given Product with id <id>
    When Send request delete product
    Then Status code should be 400
    And Response body message was "error delete data. delete faileduser unauthorized id mismatched"
    And Validate json schema "DeleteProductNotBelongUserSchema.json"
    Examples:
      | id |
      | 3  |
