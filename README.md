# first-app
**This was the first app I ever built. I haven't revisited it for improvements yet, as I'm currently reviewing everything I've learned before developing new applications or refining existing ones.**

## Introduce Spring Boot Web & Data JPA
# Courier Service

__Write an application for a courier service company

General Purpose of the Application
The application is used to assign/receive orders for a courier.

#### Business Requirements
* Courier CRUD
* Order Pickup
  * An order object should be created and assigned to the corresponding courier.
  * A courier should not be able to pick up a new order until the current order is delivered.
* Order Delivery - The courier changes the state of the order and marks it as delivered.
* Client Order Delivery Confirmation - The client must also confirm the receipt of the order.

#### Required Entities (Minimal Fields Needed)
* Courier (id, personal No, full name) // Other fields may be required
* Client (id, personal No, full name) // Other fields may be required
* Order (id, pickup address, delivery address, tracking number (should be a string)) // Other fields may be required

#### IT Requirements
* Provide Swagger documentation for each endpoint explaining what it does.
* Provide Swagger documentation for each field in the entity explaining its significance.
* Add validators to entity fields where necessary.
* Follow the best practices for REST API usage.
  * https://medium.com/@syedabdullahrahman/mastering-rest-api-design-essential-best-practices-dos-and-don-ts-for-2024-dd41a2c59133
  * https://restfulapi.net/resource-naming/
  * https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design
  * https://blog.wahab2.com/api-architecture-best-practices-for-designing-rest-apis-bf907025f5f
