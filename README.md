README
======

Users
-----
**admin** --> username: "david", password: "12345"
username: "sophie", password: "12345"
username: "aaron", password: "12345"
username: "carl", password: "12345"
username: "emma", password: "12345"

Lab 4: Catering Menu Management (100pts)
========================================
Please read and follow ALL instructions carefully. You must do all of the following to receive credit:

1. Commit your work to the lab4 GitHub repo, including the .sql file that you use to populate the databases. Place it in the sql folder
2. Please, clone the lab4 repo and work from there. Do not try to upload files from the browser.
3. Remember to add the MySQL JDBC jar to the /WEB-INF/lib of your project
4. Zip the repository and upload it to CSNS.
5. Verify that your web application works on Google Chrome

The puporse of this lab is to become familiar with using using databases from your applications.

Review  EmployeesJDBCExample and lecture 7 slides the to get started. Follow the  MySQL setup guide to get started.

**You must use PreparedStatements.**

Problem Description:
--------------------

Again, the student union director was extremely pleased with your work. Now he wants you to write an application to manage catering menus at the student union.

Here are the list of requirments:

**The following functionality shall be provided in lab4:**

1. Mandatory User login/logout
2. Allow logged in users to create Menus (for example dinner menu or breakfast menu)
3. Each Menu consists of several Dishes (for example kimchiFriedRice, eggsOnToast)
4. Each Dishes consists of several Ingredients
5. The main screen should contain a list of Menus, with links to each menu detailed view and delete functions for menu
6. On the menu detailed view, display all dishes and their ingredients information. There should be a add dish link that allows users to add a dish using existing ingredients to the current menu.
7. Menus should have at least a name, description, and list of dishes
8. Dishes should have at least a name, each ingredient and their reuired quantity
9. Ingredients should have at least a name and a price

**Hints/Steps to complete the lab**

1. Create the `.sql` script that will populate the database with initial tables and data. DO THIS FIRST.
2. Create servlet with init method to load initial data
3. Work out the other Controllers/Views as usual
4. Think very carefully about what data to store in the database. Avoid duplicate data as much as possible. For example, it probably makes sense to have a table called `dish_ingredients` to keep track the dish_ingredient relationship.

Extra Credit
------------
    Implement edit menu/dish/ingredient
    Implement file upload to allow users to upload pictures of dishes and ingredients