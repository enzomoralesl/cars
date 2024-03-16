# Cars Project
Personal Spring Boot project

## Technologies :computer:
- Framework: Spring Boot
- Language: Java 18
- Database: h2
- 
### Pre-Scripted SQL query to create database


### Endpoints

post(/api/cars)
Request:
```
{
    "model":"Car Model",
    "brand":"Car Brand",
    "carUser":"User Name"
}
```

get(/api/cars) - Response after database creation
```
[
    {
        "id": 1,
        "model": "McLaren",
        "brand": "Senna",
        "carUser": {
            "id": 1,
            "name": "Enzo Morales",
            "email": "enzo@email.com",
            "password": "enzo123"
        }
    },
    {
        "id": 2,
        "model": "Ferrari",
        "brand": "Enzo",
        "carUser": {
            "id": 2,
            "name": "Enzo Leitão",
            "email": "enzo2@email.com",
            "password": "enzo12345"
        }
    },
    {
        "id": 3,
        "model": "Porsche",
        "brand": "Macan",
        "carUser": {
            "id": 1,
            "name": "Enzo Morales",
            "email": "enzo@email.com",
            "password": "enzo123"
        }
    }
]
```
