# StudentRegistry - Student Management System

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)
![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)

## Description

StudentRegistry is a Java desktop application that implements a complete CRUD system for student management. It allows registering, querying, updating, and deleting people's information in a MySQL database, with an automated admission system based on test scores.

### Features

- **Intuitive graphical interface** built with Java Swing
- **Full student management** (create, update, and delete records, plus queries)
- **Automatic admission system** based on score and faculty
- **MySQL database connection** with connection handling
- **Data validation** and error handling
- **Layered architecture** (MVC) for easier maintenance

## Getting Started

### Prerequisites

- **Java 11** or later
- **MySQL 8.0** or later
- **Maven 3.6** or later

### Installing MySQL

#### On Windows:
1. Download MySQL Community Server from [https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)
2. Run the installer and follow the instructions
3. During the installation, make sure to:
   - Select "Server only" or "Developer Default"
   - Set a password for the root user
   - Start the MySQL service automatically

#### On macOS:
```bash
# Using Homebrew
brew install mysql
brew services start mysql
```

#### On Linux (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql
```

## Configuration

### 1. Database Setup

1. Make sure MySQL is installed and running.

2. **Option 1 - Using SQL Tools in VS Code:**
   - Open VS Code in the project folder
   - Press `Ctrl+Shift+P` and search for "SQLTools: Connect"
   - Select the "MySQL-crudPersona" connection
   - Once connected, open the `create_database.sql` file
   - Press `Ctrl+Shift+P` and search for "SQLTools: Execute Query" to run the script

3. **Option 2 - Using MySQL commands:**
   ```sql
   -- Create the database
   CREATE DATABASE IF NOT EXISTS crudPersona;
   
   -- Use the database
   USE crudPersona;
   
   -- Create the persona table
   CREATE TABLE IF NOT EXISTS persona (
       idPersona INT AUTO_INCREMENT PRIMARY KEY,
       dni VARCHAR(20) UNIQUE NOT NULL,
       nombre VARCHAR(100) NOT NULL,
       apellido VARCHAR(100) NOT NULL,
       facultad VARCHAR(100) NOT NULL,
       puntaje INT NOT NULL,
       admitido VARCHAR(2) NOT NULL
   );
   ```

### 2. Project Setup

The database connection is configured in the `data.DatabaseConnection` class with the following default parameters:
- **Host**: localhost
- **Port**: 3306
- **Database**: crudPersona
- **User**: root
- **Password**: *****

If you need to change these values, edit the constants in the `DatabaseConnection` class.

## Build and Run

### Build
```bash
mvn clean compile
```

### Run
```bash
mvn exec:java -Dexec.mainClass="presentation.PersonaFrame"
```

### Create an executable JAR
```bash
mvn clean package
java -jar target/StudentRegistry-1.0.0-jar-with-dependencies.jar
```

## Using the Application

1. When the application starts, you will see a graphical interface with fields for entering a person's data:
   - **DNI**: Unique national identity document number
   - **First name**: Person's first name
   - **Last name**: Person's last name
   - **Faculty**: Faculty the person is applying to (Ingenieria, Artes, Tecnologica, Medio_Ambiente, Ciencias)
   - **Score**: Score obtained in the admission tests

2. **Available actions:**
   - **Save**: Registers a new person in the database. The system automatically determines whether the person is admitted based on score and faculty.
   - **Edit**: Looks up a person by DNI and loads their data for editing.
   - **Update**: Saves changes made to an existing person.
   - **Delete**: Removes a person record from the database.

3. **Automatic Admission System:**
   - **Ingenieria**: Requires a minimum score of 350
   - **Artes**: Requires a minimum score of 350
   - **Tecnologica**: Requires a minimum score of 280
   - **Medio Ambiente**: Requires a minimum score of 300
   - **Ciencias**: Requires a minimum score of 320

## Project Architecture

```
src/
├── main/
│   ├── java/
│   │   ├── data/
│   │   │   ├── interfaces/
│   │   │   │   └── PersonaInterface.java      # Interface for CRUD operations
│   │   │   └── PersonaDAO.java                # CRUD operation implementation
│   │   │   └── DatabaseConnection.java        # Database connection handling
│   │   ├── model/
│   │   │   └── Persona.java                   # Person data model
│   │   ├── presentation/
│   │   │   └── PersonaFrame.java              # Graphical user interface
│   │   └── service/
│   │       └── PersonaService.java            # Business logic and services
│   └── resources/
└── test/
    └── java/
```

### Component Overview:
- **data/**: Data access layer that handles interaction with the MySQL database
- **data/interfaces/**: Defines contracts for CRUD operations
- **model/**: Classes that represent domain entities
- **presentation/**: Graphical user interface
- **service/**: Business logic and coordination between layers

## Troubleshooting

### Database Connection Error
If you get a connection error, check:
1. That MySQL is running.
2. That the connection parameters in `DatabaseConnection.java` are correct.
3. That the `crudPersona` database exists.
4. That the `root` user has the appropriate permissions.

### Error with SQL Tools in VS Code
If you get an error such as "Error opening connection" when you try to connect with SQL Tools, try the following:
1. Make sure MySQL is running
2. Check that port 3306 is available and not blocked by the firewall
3. Try connecting using the MySQL commands directly instead of SQL Tools
4. If the problem persists, you can run the `create_database.sql` script directly from the MySQL command line:
   ```bash
   mysql -u root -p < create_database.sql
   ```

### MySQL Driver Error
If there are problems with the MySQL driver, make sure the dependency is correctly declared in the `pom.xml`.

## Contributing

Contributions are welcome. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the project
2. Create a branch for your feature (`git checkout -b feature/AmazingFeature`)
3. Make your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

**Carlos Cuervo** - [@carlonox](https://github.com/carlonox)

Project link: [https://github.com/carlonox/StudentRegistry](https://github.com/carlonox/StudentRegistry)
