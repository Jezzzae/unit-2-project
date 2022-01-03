# unit-2-project
## Book Store app Sheree &amp; Jess

The bookstore app will allow a user to search for a book through a database and store favorite books into a list that they will also be able to mangage and remove.

### User Stories
***
* User should be able to look up book according to Title
* User should be able to search up book according to Author
* User should be able to search up book according to Genre 
* User should be able to search up book according to Publisher
* User can save thier favorite books in a List
* When user searches for books - The book should display Author, Genre, Publisher, and Title
* User should have the ability to remove books from list
* User should have the ability to view more information on the Author 

#### Endpoints

[Endpoints.docx](https://github.com/Jezzzae/unit-2-project/files/7804532/Endpoints.docx)
Request Type	URL	Request Body	Action	Access
Get	/books	none	get all books	Public 
Get	/books{bookid}	none	get a single book	Public
Post	/author{authorid}/{genreid}/books	book info	create a single book with an author in a genre	Public
Put	/books{bookid}
	book info	update a single book	Public
Delete	/books{bookid}
	none	delete a single book	Public
Get	/author	none	get all authors	Public
Get	/author{authorid}	none 	get a single author 	Public
Get	/author{authorid}/books
	none	get all books by an author	Public
Get	/author{authorid}/books/{bookid}
	none	get a single book by an author 	Public
Post	/author	none	create a single author	Public
Post	/publisher{publisherid}/author{authorid}	none	create a single author with a publisher 	Public
Put	/author{authorid}	none	update a single author 	Public
Delete 	/author{authorid}	none	delete a single author	Public
Get	/genre	none	get all publisher 	Public
Get	/genre{id}/name	none	gets a single publisher 	Public
Get	/author{authorid}/publisher{publisherid}	none	gets all authors in a publisher 	Public
Get	author{authorid}/name/publisher{publisherid}	none	gets a single author in a publisher 	Public
Post	/publisher	publisher info	creates a new publisher 	Public
Put	/publisher{publisherid}
	publisher info	update a publisher 	Public
Delete 	/publisher{publisherid}	none	delete a publisher 	Public
Get	/genre	none	gets all genre	Public
Get	/genre{genreid}	none	get a single genre	Public
Get	/genre{genreid}/books	none	get all books in a genre	Public
Post	/genres	genre info	creates a single genre	Public
Put	/genres{genreid}
	genre info	update a single genre 	Public
Delete	/genres{genreid}	none	deletes a single genre	Public

![image](https://user-images.githubusercontent.com/87440131/147991345-f7882137-79ed-4aab-8895-71e09bce40e2.png)



##### ERD

![ERD with colored entities (UML notation)](https://user-images.githubusercontent.com/87440131/147990682-9c42d9f5-591c-4500-b758-9136031d1bdd.jpeg)
