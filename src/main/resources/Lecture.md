STA database is a structured collection of data that supports electronic storage and manipulation

**Relational Databases**  
Organize data into structured tables with predefined schemas, where relationships between tables are defined using foreign keys

**Non-relational Databases**  
Store data in flexible formats, such as key-value pairs or wide-column stores, which allow for dynamic and unstructured data. E.g. MongoDB

**WHERE clause:** Filter before aggregation  
**HAVING clause:** Filter after aggregation

**INNER JOIN:** Only return rows when there's a match in both tables

**PreparedStatement:** Precompiled SQL Statements  

**Statement:** Single query execution  

**CallableStatement:** Is specifically used to execute queries stored in the database using stored procedures.is an interface in the JDBC API 
that allows the execution of stored procedures in a relational database. It provides a way to call SQL stored procedures from a Java 
application, enabling the benefits of stored procedures to be leveraged directly within the code.

````sql
CREATE PROCEDURE GetSalesReport()
BEGIN
    SELECT InvoiceId, Total FROM invoice;
END;
````

````java
CallableStatement cstmt = conn.prepareCall("{call GetSalesReport()}");
ResultSet rs = cstmt.executeQuery();
````

**Stored Procedure**  
A stored procedure in SQL is a saved set of SQL commands that can be executed as a single unit. Similar to a function in programming, 
it can accept input parameters, perform operations, and return results.

Stored procedures are typically saved within the database itself under a specific schema. This allows them to be reused by multiple 
applications or users without rewriting the same logic. The database management system (DBMS) stores them in a pre-compiled form, which can 
improve performance since the database doesn’t need to recompile the SQL code each time it runs.

**Statement** for static queries.  
````java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT Name FROM artist");
````
**PreparedStatement** for parameterized queries.  
````java
String query = "SELECT Title FROM album WHERE ArtistId = (SELECT ArtistId FROM artist WHERE Name = ?)";
PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setString(1, "AC/DC");
ResultSet rs = pstmt.executeQuery();
````
**CallableStatement** for stored procedures.

**try-with-resources**
The try-with-resources construct ensures that database resources are automatically closed, simplifying code and
reducing the risk of mistakes.