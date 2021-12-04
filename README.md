## Store Management Java Application
#### Qiong Wu
### 1. How to Run the Code
- This java project uses Maven to manage the build.
- In project root directory(where the pom.xml file locates) run command: 
```
java -XX:+ShowCodeDetailsInExceptionMessages -cp target/classes com.store.app.App
```
### 2. Where to put/config the files paths and the category caps.
- The default path for input Files is "store-app/src/main/resources/"
- Update the config for file path and category caps in App.java
 ![image](https://user-images.githubusercontent.com/70813818/144704288-246fdebe-3486-470e-ad9f-31c66fd8f48b.png)

### 3. Check the result.
- The output files defaultly goes to ./output directory
 ![image](https://user-images.githubusercontent.com/70813818/144704446-897b49e0-6889-4ce0-8dc8-ebec08ab6964.png)
- The Error message file named by timestring+"error_message.txt"
- The valid order output named by timestring+"output.csv"
 ![image](https://user-images.githubusercontent.com/70813818/144704458-e0616513-00e2-49af-9ef4-eb8440bb53ad.png)
### 4. Sample output/error message:
- When the request quantity on an item exceeds the in stock number
 ![image](https://user-images.githubusercontent.com/70813818/144704518-29da841a-e698-48a7-82cb-3a467292d320.png)
- When the order total requests on a category exceeds this category's cap
 ![image](https://user-images.githubusercontent.com/70813818/144704579-d08a82ca-01e7-43a6-9f62-b81584dd0154.png)
- When the order is valid and total amount is calculated
![image](https://user-images.githubusercontent.com/70813818/144704636-42a151cd-6dd0-4de1-b566-bfab133f43c2.png)
- If the card number does not exits in the database, add the card to database and print the log to console
![image](https://user-images.githubusercontent.com/70813818/144704675-7ed4eeb9-ad69-434c-8990-d7a6582d3c4b.png)

### 7. Design Patterns
- The Database class implements the Singleton Pattern, to make sure only one instance been created within the application.
- The order handler classes implement the Chain of Responsibility Pattern. 4 concrete order handler class extend from the base class Handler. They connect one by one to complete the order validation and process.  QuantityHandler -> CategoryCapHandler -> ValidOrderHandler -> CardHandler

### 6. Class Diagram
![image](https://user-images.githubusercontent.com/70813818/144704756-08e6aa83-0b30-411a-8fea-99da1e6c9f75.png)
