# Practice_Project_SimpleMailSender
Practice project to work with tables in JavaFX, Jackson, Files amd Mail.ru api;

Done in 9 hours

Created UI:
![изображение](https://github.com/SolovevAnton/Practice_Project_SimpleMailSender/assets/121192850/2d058f06-f958-4adb-8c43-5d0bc40a4979)


## Tasks
1. Create a User data model with fields: ID(integer), username, registration date (dd.MM.yyyy HH:mm:ss), email, age, country, whether the letter was sent
2. Create a repository SendUserIdRepository, the constructor of which does not accept arguments as input, loads data into a list of integers from a JSON send.json file. Make the name of this file a static constant in the Constants class of the util package. The exception in the constructor about the absence of the file must be ignored and not transferred to the signature
3. Create a repository whose constructor takes an object of the File type as input and initializes the list of users from this file. Next, in this constructor, set the isSend field to true for each object if its id is in the SendUserIdRepository repository list
4. Create UI in java FX with table, and ability to download file with users data
4. Display all users from in the table. The program should tick off in the first column of the table those users to whom letters have already been sent. 
5. Make the checkbox itself immutable from UI
5. For each line of the table in the last column there should be a “Submit” button, by clicking on which a new window opens, waiting for closing andshowing data about the user to which it belongs
6. In a new window, make fields for entering the subject of the letter (textField) and the text of the letter (textArea). By clicking on the "Send" button in this window, send a letter to the user and display a success message, saving the id of this user to the send.json file through the repository.
7. After closing the window with sending a message, it is necessary to initialize the table again so that the checkbox about sending is displayed in the first column automatically
