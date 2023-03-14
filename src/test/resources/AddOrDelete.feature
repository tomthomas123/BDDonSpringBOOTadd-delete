Feature:add/delete devices
  As an Architect, I should be able provide API for add/delete devices


  Scenario:Add data to MongoDB Through Postman
    When I make a POST request to "http://localhost:8083/device" endpoint
    Then I should receive a response with status code 200 and message show the newly added data



  Scenario:Get all the connected device list
    When  I make a GET request to start "http://localhost:8083/device" endpoint
    Then  I should receive a message


  Scenario:Delete data from MongoDB Through Postman
    When  I make a DELETE request to "http://localhost:8083/device/{id}" endpoint
    Then  I should receive a response with status code 200



