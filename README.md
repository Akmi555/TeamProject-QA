
# User Registration & Authorization Automation Berlin Travel Agency

This repository contains a comprehensive suite of automated tests for user registration and login functionality. Built with **Selenium WebDriver** and **TestNG**, this project automates the testing of various input field validations, error handling, and password visibility toggling in the user registration and login forms.

## 🚀 Features

### User Registration Tests
- **Empty Field Validation**: Ensures the system properly handles empty fields during registration (first name, last name, password).
- **Invalid Field Handling**: Verifies the application throws errors when invalid data is entered (e.g., invalid email format, short passwords).
- **Duplicate Email Handling**: Tests how the system responds when a registered email is reused during registration.

### User Authorization Tests
- **Login Functionality**: Validates that users can successfully log in with correct credentials.
- **Password Visibility Toggle**: Tests the functionality of the password visibility toggle icon and ensures password visibility can be toggled correctly.
- **Email Validation**: Verifies that invalid emails are rejected during the login process.

## 📂 Project Structure

- `com.TestBase.java`: Base class that handles the setup and teardown for the WebDriver, as well as common utilities for all tests.
- `UserAuthorizationTests/`: Tests for user login functionality, including visibility toggling for the password field.
- `RegistrationTests/`: Tests for validating user registration fields and handling various error scenarios.

## 📦 Requirements

To run this project, you’ll need the following:
- **Java** (18 or higher)
- **Gradle** (for managing dependencies and building the project)
- **Selenium WebDriver**
- **TestNG** (for running the tests)
- **ChromeDriver** (ensure it matches your installed Chrome version)

## 🛠️ Installation

1. **Clone this repository**:
   ```bash
   git clone https://github.com/Cohort47/TeamProject-QA.git
   ```

2. **Install dependencies**:
   ```bash
   gradle clean build
   ```

3**Run the tests**:
   ```bash
   gradle test
   ```

   - Alternatively, tests can be run using **TestNG** from an IDE such as IntelliJ IDEA or Eclipse.

## 📝 Test Reports

After running the tests, you can find the detailed test results in the `build/reports/tests/test` directory. Test logs and reports are available under the `build/test-results` folder.

## ⚡ Test Cases

### **UserRegistrationTests**

- **testEmptyFirstName**: Tests the case when the first name field is empty.
- **testEmptyLastName**: Tests the case when the last name field is empty.
- **testInvalidEmail**: Ensures that an invalid email address is correctly rejected during registration.
- **testInvalidPassword**: Verifies that weak passwords (less than 8 characters or without special characters) are rejected.
- **testDuplicateEmail**: Checks if the system catches an already registered email during the registration process.

### **UserAuthorizationTests**

- **testLogin**: Verifies that a user can log in using valid credentials.
- **testPasswordVisibilityToggle**: Ensures that clicking the eye icon reveals the password and clicking it again hides it.
- **testInvalidEmailLogin**: Tests how the system reacts when an invalid email is used for login.
- **testInvalidPasswordLogin**: Tests the behavior when an incorrect password is provided.

## 🧑‍💻 Contributing

We welcome contributions to improve and extend the functionality of this test suite.

### How to Contribute:

1. Fork this repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new test or feature'`).
5. Push to your forked repository (`git push origin feature-name`).
6. Open a pull request.

## 🛠️ Technologies Used

- **Selenium WebDriver**: For automating browser interactions.
- **TestNG**: A testing framework for running and managing tests.
- **Java**: The programming language used for automation.
- **Gradle**: A build automation tool used for managing dependencies and running tests.

## 📚 Additional Resources

Here are some useful resources and documentation for further details on our project:

- **Site Mockup**: [Figma Design](https://www.figma.com/design/evRk087vs1kj6C9WSy2NAd/BerlinTravelAgency?node-id=0-1&t=TTpix9GCUxd0yve3-1)
- **Database Schema**: [DrawSQL Diagram](https://drawsql.app/teams/boxwether/diagrams/laguna)
- **Team Repository**: [GitHub Repository](https://github.com/Cohort47)
- **User Stories**: [Google Sheets](https://docs.google.com/spreadsheets/d/1UYeHOXn5kmd3Y4yEEMLu5iLGqo1Pa5xvw587bIzq42M/edit?gid=0#gid=0)
- **Project Documentation**: [Google Drive](https://drive.google.com/drive/folders/12cRzOdmp6jw_Ozosvtgih7NJ2WDGmP90?usp=sharing)
- **Project Mind Map**: [MindMup](https://atlas.mindmup.com/2024/12/f5d91a30bec711ef8685c526422ade03/berlin_travel_agency/index.html)

Feel free to explore these links to understand more about the project infrastructure and design.

