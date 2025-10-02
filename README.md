# StudentRegistry - Sistema de Gestión de Estudiantes

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue)
![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Descripción

StudentRegistry es una aplicación de escritorio Java que implementa un sistema CRUD completo para la gestión de estudiantes. Permite registrar, consultar, actualizar y eliminar información de personas en una base de datos MySQL, con un sistema automatizado de admisión basado en puntajes.

### ✨ Características Principales

- 🖥️ **Interfaz gráfica intuitiva** desarrollada con Java Swing
- 📊 **Gestión completa de estudiantes** (alta, baja, modificación y consulta)
- 🤖 **Sistema de admisión automática** según puntaje y facultad
- 🗄️ **Conexión a base de datos MySQL** con manejo de conexiones
- ✅ **Validación de datos** y manejo de errores
- 🧱 **Arquitectura en capas** (MVC) para mejor mantenibilidad

## 🚀 Comenzando

### 📋 Requisitos Previos

- **Java 11** o superior
- **MySQL 8.0** o superior
- **Maven 3.6** o superior

### 🔧 Instalación de MySQL

#### En Windows:
1. Descarga MySQL Community Server desde [https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)
2. Ejecuta el instalador y sigue las instrucciones
3. Durante la instalación, asegúrate de:
   - Seleccionar "Server only" o "Developer Default"
   - Configurar el usuario root con una contraseña
   - Iniciar el servicio de MySQL automáticamente

#### En macOS:
```bash
# Usando Homebrew
brew install mysql
brew services start mysql
```

#### En Linux (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql
```

## ⚙️ Configuración

### 1. Configuración de la Base de Datos

1. Asegúrate de que MySQL esté instalado y en ejecución.

2. **Opción 1 - Usando SQL Tools en VS Code:**
   - Abre VS Code en la carpeta del proyecto
   - Presiona `Ctrl+Shift+P` y busca "SQLTools: Connect"
   - Selecciona la conexión "MySQL-crudPersona"
   - Una vez conectado, abre el archivo `create_database.sql`
   - Presiona `Ctrl+Shift+P` y busca "SQLTools: Execute Query" para ejecutar el script

3. **Opción 2 - Usando comandos de MySQL:**
   ```sql
   -- Crear la base de datos
   CREATE DATABASE IF NOT EXISTS crudPersona;
   
   -- Usar la base de datos
   USE crudPersona;
   
   -- Crear la tabla persona
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

### 2. Configuración del Proyecto

La conexión a la base de datos está configurada en la clase `data.DatabaseConnection` con los siguientes parámetros por defecto:
- **Host**: localhost
- **Puerto**: 3306
- **Base de datos**: crudPersona
- **Usuario**: root
- **Contraseña**: *****

Si necesitas cambiar estos valores, modifica las constantes en la clase `DatabaseConnection`.

## 📦 Compilación y Ejecución

### Compilación
```bash
mvn clean compile
```

### Ejecución
```bash
mvn exec:java -Dexec.mainClass="presentation.PersonaFrame"
```

### Crear JAR ejecutable
```bash
mvn clean package
java -jar target/StudentRegistry-1.0.0-jar-with-dependencies.jar
```

## 🎮 Uso de la Aplicación

1. Al iniciar la aplicación, verás una interfaz gráfica con campos para ingresar datos de una persona:
   - **DNI**: Documento Nacional de Identidad único
   - **Nombres**: Nombre completo de la persona
   - **Apellidos**: Apellido completo de la persona
   - **Facultad**: Facultad a la que aspira (Ingenieria, Artes, Tecnologica, Medio_Ambiente, Ciencias)
   - **Puntaje**: Puntaje obtenido en las pruebas

2. **Funcionalidades disponibles:**
   - **Guardar**: Registra una nueva persona en la base de datos. El sistema determinará automáticamente si es admitido según el puntaje y la facultad.
   - **Editar**: Busca una persona por DNI y carga sus datos para edición.
   - **Actualizar**: Guarda los cambios realizados a una persona existente.
   - **Eliminar**: Borra un registro de persona de la base de datos.

3. **Sistema de Admisión Automática:**
   - **Ingeniería**: Requiere puntaje mínimo de 350
   - **Artes**: Requiere puntaje mínimo de 350
   - **Tecnológica**: Requiere puntaje mínimo de 280
   - **Medio Ambiente**: Requiere puntaje mínimo de 300
   - **Ciencias**: Requiere puntaje mínimo de 320

## 🏗️ Arquitectura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   ├── data/
│   │   │   ├── interfaces/
│   │   │   │   └── PersonaInterface.java      # Interfaz para operaciones CRUD
│   │   │   └── PersonaDAO.java                # Implementación de operaciones CRUD
│   │   │   └── DatabaseConnection.java        # Gestión de conexión a la base de datos
│   │   ├── model/
│   │   │   └── Persona.java                   # Modelo de datos de Persona
│   │   ├── presentation/
│   │   │   └── PersonaFrame.java              # Interfaz gráfica de usuario
│   │   └── service/
│   │       └── PersonaService.java            # Lógica de negocio y servicios
│   └── resources/
└── test/
    └── java/
```

### Descripción de Componentes:
- **data/**: Capa de acceso a datos que maneja la interacción con la base de datos MySQL
- **data/interfaces/**: Define contratos para operaciones CRUD
- **model/**: Clases que representan entidades del dominio
- **presentation/**: Interfaz gráfica de usuario
- **service/**: Lógica de negocio y coordinación entre capas

## 🛠️ Resolución de Problemas

### Error de Conexión a la Base de Datos
Si recibes un error de conexión, verifica:
1. Que MySQL esté en ejecución.
2. Que los parámetros de conexión en `DatabaseConnection.java` sean correctos.
3. Que la base de datos `crudPersona` exista.
4. Que el usuario `root` tenga permisos adecuados.

### Error con SQL Tools en VS Code
Si al intentar conectar con SQL Tools recibes un error como "Error opening connection", prueba lo siguiente:
1. Asegúrate de que MySQL esté en ejecución
2. Verifica que el puerto 3306 esté disponible y no bloqueado por el firewall
3. Intenta conectarte usando los comandos de MySQL directamente en lugar de SQL Tools
4. Si el problema persiste, puedes ejecutar el script `create_database.sql` directamente en la línea de comandos de MySQL:
   ```bash
   mysql -u root -p < create_database.sql
   ```

### Error de Driver MySQL
Si hay problemas con el driver de MySQL, asegúrate de que la dependencia esté correctamente declarada en el `pom.xml`.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para cambios importantes, por favor abre un issue primero para discutir lo que te gustaría cambiar.

1. Haz un fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Realiza tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 👤 Contacto

**Carlos Cuervo** - [@carlonox](https://github.com/carlonox)

Link del proyecto: [https://github.com/carlonox/StudentRegistry](https://github.com/carlonox/StudentRegistry)
