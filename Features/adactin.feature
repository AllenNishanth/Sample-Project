Feature: To validate login feature
Scenario: validate using valid username password
    Given User is entering https://adactinhotelapp.com/
   # When user enters "Andrew07" "UN45LL"
  # When user enters the data
When end user enters the data
  |userName | Password|
  |Andrew07 | UN45LL|
  
   
  #  When end user uses multiple data "<userName>" "<Password>"
    And click LogIn button
    Then user should see the booking page
   
#Examples:
 #  |userName | Password|
  # |Andrew07 | UN45LL|
   #|Andrew07 | UN45LL|
   