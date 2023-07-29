# Microservices Project with Spring Boot



This repository contains a comprehensive microservices project built with Spring Boot, showcasing the power and flexibility of the microservices architecture. The project consists of three core microservices, each serving a specific purpose: User Service, Rating Service, and Hotel Service. Additionally, it includes an API Gateway for secure access and a Config Server for centralizing configurations.

## Features

- **User Service**: Handles user information and their hotel ratings, communicating with Rating Service and Hotel Service via REST templates.

- **Rating Service**: Manages user ratings, associating them with unique user IDs and hotel IDs for personalized insights.

- **Hotel Service**: Stores detailed hotel information using a MongoDB database.

- **Eureka Service Registry**: Utilizes Netflix Eureka server for easy service discovery and registration.

- **Feign Client**: Enables seamless internal communication between microservices through Feign clients.

- **API Gateway**: Provides secure access to microservices, restricting direct user reach.

- **Security with Okta**: Implements robust authentication and authorization using Okta.

- **Resilience with Resilience4j**: Ensures fault tolerance with circuit breaker patterns, retries, and rate limiters using Resilience4j.

- **Config Server with GitHub**: Centralizes common configurations using a Config Server linked to GitHub.

## Prerequisites

- Java 8 or above
- MySQL database for User and Rating Services
- MongoDB for Hotel Service
- GitHub account for storing configurations

## Getting Started

Follow these steps to get the project up and running:

1. Clone the repository to your local machine.

2. Update the database configurations for each microservice in their respective `application.properties` files.

3. Set up MongoDB and MySQL databases as specified in the configurations.

4. Configure Okta for authentication and authorization as per your requirements.

5. Run the Config Server and link it to your GitHub account to centralize configurations.

6. Start the Eureka Service Registry and register each microservice as Eureka clients.

7. Run each microservice in the following order: Config Server -> Eureka Service Registry -> User Service -> Rating Service -> Hotel Service -> API Gateway.

8. Your microservices architecture with Spring Boot is now up and running! You can access the API Gateway to interact with the services securely.

## How to Contribute

Contributions are welcome! To contribute to this project, follow these steps:

1. Fork the repository.

2. Create a new branch for your feature/bugfix.

3. Make your changes and ensure that they are properly tested.

4. Commit your changes and push them to your fork.

5. Submit a pull request, detailing the changes you made and any relevant information.

6. Your contribution will be reviewed, and once approved, it will be merged into the main repository.


## Contact

For any questions or feedback, please feel free to reach out to me at [mangoreyush@gmail.com](mailto:mangoreyush@gmail.com).

---

Thank you for exploring this Microservices Project with Spring Boot! We hope you find it insightful and valuable. If you have any suggestions or ideas for improvements, please let us know. Happy coding! 🚀🌟
