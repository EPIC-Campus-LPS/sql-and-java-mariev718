# Lab 4: SQL Databases and Java 

## Part 1: Creating a SQL Database
1. Turn `top_sellers.csv` into a database
2. List the steps to set up your SQL database here:
    1. Select 'Database' from the top menu, then select 'Connect to Database' and then 'OK'
   2. Select a default schema and create a new table under it (right click on 'Tables')
   3. Create the columns and then select apply
   4. Then right-click on the new table on the left menu
   5. Select 'Table Data Import Wizard' and import the CSV

## Part 2: Java to SQL
1. Choose a dataset with multiple tables off [Kaggle](https://www.kaggle.com/)
2. Create a MySQL database with at least three of the tables. There should be at least one **primary key**/**foreign key** relationship in your dataset.
3. Use [DBDiagram](https://dbdiagram.io/d) or similar to make a schema diagram for your database. Upload this to your GitHub.
4. Create a Java project to interact with your database. Your code should provide three examples each of `SELECT`, `UPDATE`, `INSERT INTO`, and `DELETE` statements.
  - [Java/MySQL Windows](https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/)
  - [StackOverflow](https://stackoverflow.com/questions/2839321/connect-java-to-a-mysql-database)
  - [Another Example](https://www.vogella.com/tutorials/MySQLJava/article.html)
5. Include Javadoc comments and test cases to verify your commands work. 
6. Demonstrate your project and your test cases to me in class before turning your project in.
7. When you are done, submit your Java files, your schema diagram and this README to your repository. 
