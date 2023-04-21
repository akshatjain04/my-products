# My-Products

A sample JAVA SpringBoot application that uses Java Persistence API to implement CRUD operations. 

## Getting Started

To launch the app:

### Using Local Run

Right click on the [ProductionApplications.java](https://github.com/akshatjain04/my-products/blob/main/src/main/java/com/bootexample4/products/ProductsApplication.java) file, and click on `Run Java`.

### Using Dockerfile

1. Build the docker image in the base directory:
     `docker build -t my-products:1.0 .`
2. Run the image:
     `docker run -d -p 8080:8080 my-products:1.0`

In both the cases, the app must be accessible at http://localhost:8080/

## What the app does

A product has following properties:

- id  (primary key for table)
- name
- description
- price

The app supports CRUD (Create, Read, Update, Delete) operations

- [GET] Get the list of all products: `/api/products/` (This is the only api that is accessible through browser. Rest all can only be accessed from a testing tool, e.g. postman)
- [POST] Add a product: `/api/products/` request body:`{ name: string, price: float, description: string }`
- [GET] Get the product of a particulatr id: `/api/products/{id}`
- [PUT] Update a particular product by id: `/api/products/{id}` Request body: `{ name: string, price: float, description: string }`
- [DELETE] delete a particualr product by id: `/api/products/{id}`

