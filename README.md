# Multithreaded Web Server

A high-performance Java-based web server built with **Executor Framework** for handling multiple client requests concurrently. The implementation leverages a **thread pool** to optimize resource utilization and reduce latency under heavy load.

## Features

- **Concurrent Request Handling**: Supports multiple client connections simultaneously using a thread pool.
- **Thread Pool Optimization**: Eliminates per-request thread creation overhead by utilizing Java's `ExecutorService`.
- **Improved Performance**: Achieved approximately **50% throughput improvement**, increasing from about **150 to 250 requests per second**.
- **Scalable Architecture**: Designed to handle high-load scenarios with stable performance.
- **Low Latency Response**: Ensures minimal response time even under concurrent access.

## Tech Stack

- **Language**: Java
- **Concurrency**: Executor Framework
- **Build Tool**: Maven
- **Version Control**: Git

## Project Structure
├── .idea # IntelliJ project settings <br>
├── src <br>
│ └── main <br>
│ └── java # Java source files <br>
├── pom.xml # Maven configuration file <br>
└── .gitignore # Ignored files <br>

## How It Works

1. The server listens for incoming HTTP requests on a specified port.
2. Incoming connections are assigned to worker threads managed by a fixed-size thread pool using `ExecutorService`.
3. Each request is processed concurrently, improving server throughput and responsiveness.
4. Thread pooling reduces overhead by reusing threads instead of creating new ones for every request.

## Key Classes

- **Server.java**: Initializes the server socket and manages incoming connections.
- **RequestHandler.java**: Handles the logic for processing individual client requests.
- **ThreadPoolExecutor**: Manages the pool of worker threads for concurrency.

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven installed

### Compile and Run
```bash
# Clone the repository
git clone https://github.com/ArujAnand/Multithreaded-Web-Server.git

# Navigate into the project directory
cd Multithreaded-Web-Server

# Compile the project
javac Server.java RecvMsg.java

# Run the server
