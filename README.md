# Helping-The-Homeless

### Background and Purpose

Helping the Homeless is a project undertaken with the goal of creating an emergency resource to be used by people struggling with homelessness. Currently, the number of people that are homeless in Toronto is growing, which is causing the occupancy rate of shelters in Canada to increase.

This product enables users to find the best shelters to go to based on current location, distance,and occupancy rate, as well as the closest cooling centres. This would help solve the problem by getting more people a place to sleep at night.

The data sets used are the daily shelter occupancy data for Toronto from 2017 and 2018, the cooling centre locations in Toronto, and all the municipal addresses in Toronto.

The product consists of a simple GUI that allows a user to find the best shelter based on certain parameters (type of user, type of shelter) or find the closest cooling centre. Both options also have the user to see the directions from their location to the desired shelter or cooling centre in Google Maps.

***This purpose of this project was to gain experience with object oriented programming, various data structures, algorithm implementations, testing, and software development.***

### How We Did It

The raw data, which consisted of 500,000+ lines stored in csv files is read in and stored in Abstract Data Types (ADT'S) like AddressT, LocationT. These ADT's, along with other data structures like Max Priority Queue (MaxPQ), Ternary Search Trie (TST), and efficient algorithm implementations (searching, sorting) on those data strctures, are used to find the ***best*** shelter.

The Princeton algorithm code (https://algs4.cs.princeton.edu/code/) was used for the data structures and algorithms after researching which ones would be ideal for our use case. The ADT's were implemented ourselves obviously.

For more information and in-depth documentation, see ***docs*** (https://github.com/samm82/Helping-The-Homeless/tree/master/doc) for generated Javadoc or ***documentation*** (https://github.com/samm82/Helping-The-Homeless/tree/master/documentation) for further written documentation.

### Application Screenshots

Initial screen on application launch

<img src="https://github.com/samm82/Helping-The-Homeless/blob/master/application-screenshot-images/open-screen.png">

After clicking on "Find Shelter," user details have to be entered.

<img src="https://github.com/samm82/Helping-The-Homeless/blob/master/application-screenshot-images/find-shelter.png">

After clicking "Find Shelter" the best shelter is shown. This can be opened in google maps. Clicking "Next" would show the next best shelter.

<img src="https://github.com/samm82/Helping-The-Homeless/blob/master/application-screenshot-images/shelter-found.png">\

If clicked "Find Nearest Cooling Center"

<img src="https://github.com/samm82/Helping-The-Homeless/blob/master/application-screenshot-images/find-cooling-center.png" width="376" height="154"> <img src="https://github.com/samm82/Helping-The-Homeless/blob/master/application-screenshot-images/cooling-center-found.png" width="354" height="202">

