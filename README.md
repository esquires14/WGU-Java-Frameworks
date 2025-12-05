<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## Bits & Bytes Custom PC Shop Project

Name: Emily Squires

Student ID:

Date: 12/05/2025

## Parts C-J:

### Part C:
    Prompt: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
    File Name: mainscreen.html
    Line Number: 1-312
    Change Made: Customized the HTML UI to my PC shop and added a bit of css and styling.

### Part D:
    Prompt:  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
    File Name: about.html, MainScreenControllerr.java
    Line Number: 1-26(about.html) & 55-63(MainScreenControllerr.java)
    Change Made: Made an about.html for the Custom PC Shop and added to the MainScreenControllerr.java to have a nav to and from mainscreen.html and about.html.

### Part E:
    Prompt: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    File Name: BootStrapData.java
    Line Number: 32-157
    Change Made: Added my 5 parts and 5 products to the inventory, multi-pack part added as well for duplicates.

### Part F: 
    Prompt: F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters: •  The “Buy Now” button must be next to the buttons that update and delete products. • The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts. •  Display a message that indicates the success or failure of a purchase.
    File Name: mainscreen.html, MainScreenControllerr.java, Product.java, ProductService.java, ProductServiceImpl.java
    Line Number: MainScreenController.java(lines 69-99), mainscreen.html(lines 299-334), Product.java(lines 109-113), ProductService.java(line 23), ProductServiceImpl.java(lines 66-69).
    Change Made: Added a Buy now button that shows when purchased and shows the inventory go down. 

### Part G:
    Prompt: G.  Modify the parts to track maximum and minimum inventory by doing the following: •  Add additional fields to the part entity for maximum and minimum inventory. •  Modify the sample inventory to include the maximum and minimum fields. •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values. •  Rename the file the persistent storage is saved to. •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
    File Name: Part.java, AddInhousePartController.java, AddOutsourcedPartController.java, InhousePartForm.java, OutsourcedPartForm.java, application.properties
    Line Number: Part.java(lines 24, 40), AddInhousePartController.java(lines 38-53), AddOutsourcedPartController.java(lines 37-52), InhousePartForm(lines 46-69), OutsourcedPartForm(lines 54-78), application.properties(lines 13).
    Change Made: Modified parts to track the min and max inventory. 

### Part H:
    Prompt: H.  Add validation for between or at the maximum and minimum fields. The validation must include the following: •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts. •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum. •  Display error messages when adding and updating parts if the inventory is greater than the maximum.
    File Name: mainscreen.html
    Line Number: 199-204
    Change Made: 

### Part I:
    Prompt: I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
    File Name: PartTest.java
    Line Number: 162-214
    Change Made: Added 2 unit tests for max and min fields.

### Part J:
    Prompt:
    File Name:
    Line Number:
    Change Made: 