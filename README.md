# Cars Project
Personal Spring Boot Back-end Software

## Technologies :computer:
- Framework: Spring Boot
- Language: Java 18
- Database: h2
- Build: Maven
- IDE: IntelliJ IDEA
- API Testing: Postman
- Documentation: Swagger
- Version Control: Git
- Code Repository: GitHub
- CI/CD: GitHub Actions

### Pre-Scripted SQL query to create database
```
INSERT INTO CAR_USER(name, email, password) VALUES('Enzo Morales', 'enzo@email.com', 'enzo123');
INSERT INTO CAR_USER(name, email, password) VALUES('Enzo Leitão', 'enzo2@email.com', 'enzo12345');

INSERT INTO CAR(model, brand,  status, car_user_id) VALUES('McLaren', 'Senna',  'NO_STATE', 1);
INSERT INTO CAR(model, brand,  status, car_user_id) VALUES('Ferrari', 'Enzo',  'NEW', 2);
INSERT INTO CAR(model, brand,  status, car_user_id) VALUES('Porsche', 'Macan',  'PRE_OWNED', 1);
```

## Endpoints
- POST(/api/v1/cars)
Request:
```
{
    "model": "Sedan",
    "brand": "Ford",
    "carUser": {
            "name": "Enzo Leitão",
            "email": "enzo2@email.com",
            "password": "enzo12345"
        },
    "status": "NEW"
}
```


- GET(/api/v1/cars)
Request Query Params:
```
email: {email}
```

Response:
```
{
    "payload": [
        {
            "id": 1,
            "model": "McLaren",
            "brand": "Senna",
            "carUser": {
                "id": 1,
                "name": "Enzo Morales",
                "email": "enzo@email.com",
                "password": "enzo123"
            },
            "status": "NO_STATE"
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
            },
            "status": "NEW"
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
            },
            "status": "PRE_OWNED"
        }
    ],
    "message": "Cars listed by search",
    "status": 200
}
```


- GET(/api/v1/cars/{email}) - /api/v1/cars/enzo@email.com
Response:
```
{
    "payload": [
        {
            "id": 1,
            "model": "McLaren",
            "brand": "Senna",
            "carUser": {
                "id": 1,
                "name": "Enzo Morales",
                "email": "enzo@email.com",
                "password": "enzo123"
            },
            "status": "NO_STATE"
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
            },
            "status": "PRE_OWNED"
        }
    ],
    "message": "Cars listed by user email",
    "status": 200
}
```
