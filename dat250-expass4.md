Experiment 2 questions:
Explain the used database and how/when it runs:
As shown in the persistence.xml our database is a H2 database which is an in-memory (or file-based) database making it lightweight, fast, and easy to use. It runs automatically when the application starts and persists data in a local file.

Hibernate is the JPA provider (ORM framework) used to manage interactions between Java objects and the database. It auto-generates the schema at startup (hibernate.hbm2ddl.auto=create). When it runs the database starts as soon as the EntityManagerFactory is initialized in the main application, and remains active while the application runs.

`<property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>`: This tells Hibernate to use the H2 dialect, which provides the SQL syntax and functions specific to H2.

`<property name="hibernate.connection.driver_class" value="org.h2.Driver"/>`: Specifies the JDBC driver for H2.

`<property name="hibernate.connection.url" value="jdbc:h2:file:./DB;DB_CLOSE_DELAY=-1"/>`: This configures the connection URL for the H2 database.
`jdbc:h2:file:./DB` tells Hibernate to use a file-based database located in the current directory (./DB). If this file does not exist, H2 will create it automatically.
The `DB_CLOSE_DELAY=-1` setting tells H2 not to close the database after the last connection is closed, meaning the database will remain available while the application runs.

DB Provider
`<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>`: This indicates that the JPA implementation used is Hibernate. Hibernate manages the mapping between Java objects (entities) and the database tables, and it generates the appropriate SQL for interacting with the database.

Schema Creation:
`<property name="hibernate.hbm2ddl.auto" value="create"/>`:
This property configures how Hibernate interacts with the database schema. `hibernate.hbm2ddl.auto=create` means that each time the application starts, Hibernate will:

- Drop any existing tables.
- Recreate the tables based on the entity definitions.
