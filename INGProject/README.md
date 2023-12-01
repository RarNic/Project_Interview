usage: git [--version] [--help] [-C <path>] [-c <name>=<value>]
           [--exec-path[=<path>]] [--html-path] [--man-path] [--info-path]
           [-p | --paginate | -P | --no-pager] [--no-replace-objects] [--bare]
           [--git-dir=<path>] [--work-tree=<path>] [--namespace=<name>]
           [--super-prefix=<path>] [--config-env=<name>=<envvar>]
           <command> [<args>]

=================================PRODUCT MANAGEMENT PROJECT====================================

      Content
      - How to start
      - Configuration
      - Application summary
      - Product API (structure clases and functionalities)
      - User API (structure clases and functionalities)


   How to start
      - open a besh shell in the folder you want the project to be with 'cd' command
      - run 'git clone https://github.com/RarNic/Project_Interview.git'
      - open the project in your IDE.
      - you need to download your JDBC Driver.
      - install MySQL locally and download if needed a tool to manipulate the data.(MySQLWorkbench)

   Configuration
      - create a connection and create your database. 
      - to set the database in the project please check the 'INGProject/src/main/resources/application.properties' in the project tree.
      - in the application.properties please set your database name.Also set your Username and Password
      - before you start, run a maven clean - install from the IDE UI or from the terminal 'mvn clean' and 'mvn install'

   Application summary
      The application is a monolith app containing two microservices.
      The purpose of this application is to create a porduct management and a user management with authentification and authorization.

   Product API 
      - structure : We have a three layer structure :
                     - presentation layer: Is the controller package that expose the resources to the internet
                     - service layer: contains the bussiness layer that contain several packages.
                     - repository layer: contains the actual data content of the project. The interaction with the database
      - functionalities : On service layer we create the logic for create, find, update and delete a product.
                          We separate de data through different data model like: - ProductModel used for bussiness processing
                                                                                 - DTOs used for controllers   
                                                                                 - entities for repository layer
                          All these data clases are mapped to one model to another through 'Mapper' class.
                          In DAO classes are implemented the data manipulation like find, delete, create and those implementations are used in "Service" Class
                          There are also implemented a series of exception handling.
   
   User API
      - has the same structure as Product API.
      - the difference apper on the Controller layer where the user is verify with the data from the db.
      - in the lack of a frontend we decided to send the user and password in the url as path variables(not a good practice at all - security issue)
      
      