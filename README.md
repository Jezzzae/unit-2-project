# unit-2-project
## Book Store app Sheree &amp; Jess

The Book StoreApp will allow a user to search for a book through a (predefined)database and save favorite books into a list that they will also be able to mangage by choosing which books to save, update, read, and remove.

### Technical requirements
- [x] Persist at least four models.
- [x] Use Spring Profiles for environment settings.
- [x] At least one API endpoint must perform full CRUD create, read, update, and delete actions.
- [x] Other API endpoints can perform CRUD based on the business use-case.
- [ ] Expose CRUD routes that were built using REST conventions.
- [x] Handle exceptions gracefully.
- [x] Send appropriate messages back to the client in the event that an exception occurs.
- [x] Must have Controller and Service separate.
- [x] Document each end-point, such that

### Necessary Deliverables
- [x] A Git repository hosted on GitHub.~~
- [x] Around 70 commits (or more) on GitHub, dating back to the very beginning of the project. (Commit early, commit often. Tell a story with your commits. Each message should         give a clear idea of what you changed.)~~
- [x] A README.md file with:
* Explanations of the machineries used.
* A couple of paragraphs about the general approach you took.
* Descriptions of any unsolved problems or major hurdles you had to overcome.
* A link to your planning documentation for how you broke down this project with deliverables and timelines.
* Installation instructions for any dependencies.
* A link to your user stories, ERD diagrams — who are your users, what do they want, and why?

### User Stories
***
* Book information is predefined
* Will not be allowed to modify any of the database data 
* When searching for books - The book should display Author, Genre, Publisher, and Title
* Will be able to find a book according to Title
* Will be able to find a book according to Author
* Will be able to find a book according to Genre
* Will be able to find a book according to Publisher
* Ability able to move favorite books into a List
* Ability to add, view, update and remove books from list
* When searching for books by name of author - The author bio, num of books, and series by that author will be displayed.
* When searching for books by the Genre - Should display the name of genre, and the name of books under that genre
* When searching for a book under publisher- The publishers' name, the name of authors under publisher, and any books published by that publisher will be displayed

#### Struggles
* Getting project approved first day 
* understanding the scope of our project and implementing that into our erd diagram
* understanding how to merge and pull / push without causing any more erros
* In the begining and even close to the middle of the week as a team we struggled to work in sync and this caused problems that directly effected our code for example when merging, pulling,pushing there was always an error that would hold us back again due to us working on files at the same time. The way we solved this was by taking our Squad Leader Suresh's advice and practicing driving & navigating together this way we avoided any unecessary git erros.


#### Approach
The way we first came about approaching our project started off rocky- We tried to divide and conquer tasks but very soon learned that was not the best way to work for us. After our struggles with that we started to join our efforts to work on the same problems this was more efficient for us because altough it seemed like it would take more time this method allowed us both to understand the concepts better by disscusing them as we went by. We tried to divide the workload of the project amoung us into certain days as seen below for example on monday we were dedicated to setting up the Spring enviroment which we finished before the end of the day. Then after we started tuesdays workload which is where we started to fall behind on because as demonstrated below there where more objectives to be met and as said before our way of working up until the end of tuesday was still divide and conquer. Once we started working in sync we approached each day with objectives that were put in place and personally curated for our team by our squad leader to help us stay on track.

#### Dependencies
*

#### Machineries Used
* Service Class talks to The Controller which talks to the Repository
* LucidCharts website to create our entity relationship models
* Postman --> We used postman(API platform) to help us test and build our endpoints
* PgAdmin --> we used pgadmins sources to help us interact with our databases in viewing our tables that we built
* IntelliJ --> worked inside of intelliJ wrtitng code to create our monolithic back-end. Within intelliJ we were able to sync up to springboot in order to use tomcat to run our application.
* Maven --> Helping to building dependencies
* Spring Boot --> Helped us in the running of our actual project without needing an external webserver - Instead we can use an embedded web server to run it, which in our case we used Tomcat
##### Endpoints
![Endpoints1](https://user-images.githubusercontent.com/87440131/148090619-c19d091c-79a9-4c27-8eef-c25fe6782682.jpg)
![Endpoints2](https://user-images.githubusercontent.com/87440131/148090637-71497e99-cb71-4c75-abf2-b88fdafa584a.jpg)
###### ERD
![ERD with colored entities (UML notation)](https://user-images.githubusercontent.com/87440131/148090715-d84a159d-05e6-468b-86b6-367f8777aa73.png)
###### Timeline
![image](https://user-images.githubusercontent.com/87440131/148092580-acfd1470-5c46-49fa-a921-5a157a2b653d.png)

<mark> ## INSTRUCTIONS(STEP BY STEP) </mark>
*
