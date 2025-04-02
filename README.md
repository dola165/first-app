[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/TOBjUFF-)
# introduce Spring Boot Web & Data JPA
## Courier Service

__დაწერეთ საკურიერო მომსახურების კომპანიის აპლიაკაცია__

აპლიკაციის ზოგადი დანიშნულება  
აპლიკაციით ხდება კურიერისთვის შეკვეთის მიცემა/ჩაბარება. 

#### ბიზნეს მოთხოვნები
* კურიერის CRUD
* შეკვეთის აღება
  * უნდა მოხდეს შეკვეთის ობიექტის შექმნა და შესაბამის კურიერზე მინისება (assign)
  * სანამ კურიერი შეკვეთას არ ჩააბარებს არ შეეძლოს სხვა ახალი შეკვეთის აღება
* შეკვეთის ჩაბარება - კურიერი შეკვეთის stateს შეცვლის და მონიშნავს რომ ჩააბარა.
* კლიენტის მიერ შეკვეთის ჩაბარების დასტური - კლიენტმაც უნდა დაადასტუროს შეკვეთის მიღება.


#### მოთხოვნილი entity-ები (მინიმალური საჭირო ველები)
* კურიერი (id, personal No, სრული სახელი) // _შეიძლება სხვა ველებიც იყოს საჭირო_
* კლიენტი (id, personal No, სრული სახელი) // _შეიძლება სხვა ველებიც იყოს საჭირო_
* შეკვეთა (id, შეკვეთის აღების მისამართი, შეკვეთის ჩაბარების მისამართი, ზედნადები(იყოს string)) // _შეიძლება სხვა ველებიც იყოს საჭირო_

#### IT მოთხოვნები
* თითოეულ endpointს დააწერეთ swagger-ის განმარტება რას აკეთებს ის 
* entity-ს თითოეულ ველს დააწერეთ swagger-ის განმარტება რას მნიშვნელობას ინახავს ის  
* entity-ების ველებს დაადეთ ვალიდატორები თუ ეს საჭიროა
* დაიცავით REST-ის საუკეთესო გამოყენების მიდგომები
  * https://medium.com/@syedabdullahrahman/mastering-rest-api-design-essential-best-practices-dos-and-don-ts-for-2024-dd41a2c59133
  * https://restfulapi.net/resource-naming/
  * https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design
  * https://blog.wahab2.com/api-architecture-best-practices-for-designing-rest-apis-bf907025f5f
  

