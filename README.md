# Weather API

A RESTful Weather API built with **Spring Boot** that fetches real-time weather information using the **OpenWeather API**. The application converts a city name into geographical coordinates using the Geocoding API and retrieves current weather details such as temperature, humidity, wind speed, and weather conditions.

---

## Features

- Get current weather by city name
- OpenWeather Geocoding API integration
- Real-time weather data
- RESTful API
- DTO-based response structure
- Global exception handling
- Custom exception for invalid cities
- Constructor-based Dependency Injection
- Layered Spring Boot architecture

---

## Tech Stack

### Backend

- Java 17
- Spring Boot 3
- Spring Web
- RestTemplate
- Maven

### API

- OpenWeather Geocoding API
- OpenWeather Current Weather API

---

## Project Structure

```
weather-api
│
├── config
│   └── AppConfig.java
│
├── controller
│   └── WeatherController.java
│
├── service
│   └── WeatherService.java
│
├── model
│   ├── Current.java
│   ├── GeocodingResponse.java
│   ├── Result.java
│   ├── WeatherDto.java
│   └── WeatherResponse.java
│
├── exception
│   ├── CityNotFoundException.java
│   └── GlobalExceptionHandler.java
│
├── WeatherApiApplication.java
│
└── application.properties
```

---

## Application Architecture

```
Client
   │
GET /weather?city=Chennai
   │
   ▼
WeatherController
   │
   ▼
WeatherService
   │
   ├── Call Geocoding API
   │
   ├── Get Latitude & Longitude
   │
   ├── Call Weather API
   │
   ▼
OpenWeather API
   │
   ▼
Weather DTO
   │
   ▼
Client
```

---

## API Endpoint

### Get Current Weather

```
GET /weather?city={cityName}
```

Example

```
GET http://localhost:8080/weather?city=Chennai
```

---

## Sample Response

```json
{
    "city": "Chennai",
    "temperature": 31.4,
    "humidity": 74,
    "windSpeed": 4.6,
    "weather": "Cloudy"
}
```

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/your-username/weather-api.git
```

### Navigate to Project

```bash
cd weather-api
```

### Configure API Key

Update your

```
src/main/resources/application.properties
```

Example

```properties
weather.api.key=YOUR_OPENWEATHER_API_KEY
```

---

### Run Application

```bash
mvn spring-boot:run
```

Application starts on

```
http://localhost:8080
```

---

## Exception Handling

The application provides centralized exception handling using

- `@ControllerAdvice`
- `@ExceptionHandler`
- Custom Exception (`CityNotFoundException`)

Example Error Response

```json
{
    "message": "City not found"
}
```

---

## Design Pattern

The project follows the layered architecture:

```
Controller
      │
      ▼
Service
      │
      ▼
External Weather API
```

The controller handles HTTP requests, the service contains business logic and API integration, and DTOs are used to return clean responses to clients.

---

## Learning Outcomes

This project helped in learning

- Spring Boot REST APIs
- REST API Consumption using RestTemplate
- OpenWeather API Integration
- JSON Mapping
- DTO Design
- Constructor Injection
- Exception Handling
- Layered Architecture
- HTTP Request & Response Handling

---

## Future Improvements

- 5-Day Weather Forecast
- Hourly Forecast
- Air Quality Index (AQI)
- Weather Icons
- Unit Testing (JUnit & Mockito)
- API Documentation using Swagger
- Redis Caching
- Docker Support

---

