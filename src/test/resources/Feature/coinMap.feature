Feature: coin map api validation

@tc01_api_coinMap
Scenario: coin map api validation
Given Make a get call for "https://coinmap.org/api/v1/venues/"
And Get the count of categories list like atm, cafe, shopping, food, lodging , attraction , default are available
And get the names of only “food” category and geo locations

