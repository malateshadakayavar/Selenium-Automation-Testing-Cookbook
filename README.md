# Selenium-Automation-Testing-Cookbook
A comprehensive collection of Selenium WebDriver automation examples in Java. Covers dropdowns, date pickers, alerts, file downloads, drag &amp; drop, keyboard actions, waits, and link validation. Perfect for learning web automation testing with practical, ready-to-run code examples.


# Selenium WebDriver Automation Examples

A comprehensive collection of Selenium WebDriver automation examples demonstrating various web testing scenarios and interactions using Java.

## 📋 Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Features](#features)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## 🔍 Overview

This project contains practical Selenium WebDriver examples that demonstrate how to automate various web interactions including:

- Dropdown handling (static, dynamic, bootstrap, jQuery)
- Auto-suggestions and search functionality
- Date picker interactions
- File downloads (PDF, Word documents)
- Alert handling
- Screenshot capture
- Drag and drop operations
- Keyboard actions
- Wait strategies
- Link validation
- Browser navigation

## 📋 Prerequisites

Before running these examples, ensure you have the following installed:

- **Java Development Kit (JDK)** 8 or higher
- **Maven** (for dependency management)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)
- **Web Browsers** (Chrome, Firefox, Edge)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/selenium-webdriver-examples.git
   cd selenium-webdriver-examples
   ```

2. **Install dependencies**
   
   Add the following dependencies to your `pom.xml`:
   
   ```xml
   <dependencies>
       <!-- Selenium WebDriver -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.15.0</version>
       </dependency>
       
       <!-- WebDriverManager -->
       <dependency>
           <groupId>io.github.bonigarcia</groupId>
           <artifactId>webdrivermanager</artifactId>
           <version>5.6.0</version>
       </dependency>
       
       <!-- Apache Commons IO -->
       <dependency>
           <groupId>commons-io</groupId>
           <artifactId>commons-io</artifactId>
           <version>2.11.0</version>
       </dependency>
   </dependencies>
   ```

3. **Create necessary directories**
   ```bash
   mkdir screenshots
   mkdir Downloads
   ```

## 📁 Project Structure

```
selenium-webdriver-examples/
├── src/
│   └── main/
│       └── java/
│           ├── AutoCompletingGoogleSuggestionDropDown.java
│           ├── AutoSuggestDropdown.java
│           ├── AutoSuggestDropdownGoogleSearch.java
│           ├── BootstrapDropdown.java
│           ├── CaptureScreenShots.java
│           ├── CheckDropDownSorted.java
│           ├── DatePicker.java
│           ├── DatePickerDropDown.java
│           ├── DownloadPdfFile.java
│           ├── DownloadWordFile.java
│           ├── DragAndDrop.java
│           ├── FluentWait.java
│           ├── HandleAlerts.java
│           ├── HandleBrokenLink.java
│           ├── HandleDropdown.java
│           ├── HandleJqueryDropDown.java
│           ├── HandleLinks.java
│           ├── KeyboardActions.java
│           ├── KeyBoardActionsMultipleKeys.java
│           └── Navigations.java
├── screenshots/
├── Downloads/
├── pom.xml
└── README.md
```

## ✨ Features

### 🔽 Dropdown Handling
- **Static Dropdowns**: Standard HTML select elements
- **Bootstrap Dropdowns**: Modern web framework dropdowns
- **jQuery Dropdowns**: Dynamic JavaScript-based dropdowns
- **Auto-suggest Dropdowns**: Search-as-you-type functionality

### 📅 Date Pickers
- **Simple Date Picker**: Calendar widget interaction
- **Dropdown Date Picker**: Month/year selection with dropdowns

### 📥 File Operations
- **Download Files**: Automated PDF and Word document downloads
- **Screenshot Capture**: Full page and element-specific screenshots

### 🎯 User Interactions
- **Alert Handling**: JavaScript alerts, confirms, and prompts
- **Drag and Drop**: Element manipulation
- **Keyboard Actions**: Single and multiple key combinations
- **Mouse Actions**: Click, hover, and context menu operations

### ⏳ Wait Strategies
- **Fluent Wait**: Flexible waiting with custom conditions
- **Implicit Wait**: Global timeout settings

### 🔗 Link Management
- **Link Validation**: Broken link detection
- **Link Navigation**: Programmatic link clicking

## 🚀 Usage

Each Java file can be run independently. Here are some examples:

### Running a Basic Dropdown Example
```bash
javac -cp "path/to/selenium-jars/*" HandleDropdown.java
java -cp ".:path/to/selenium-jars/*" HandleDropdown
```

### Running Screenshot Capture
```bash
javac -cp "path/to/selenium-jars/*" CaptureScreenShots.java
java -cp ".:path/to/selenium-jars/*" CaptureScreenShots
```

## 📖 Examples

### 1. Handling Static Dropdowns
```java
// Select dropdown by visible text, value, or index
Select dropdown = new Select(element);
dropdown.selectByVisibleText("Canada");
dropdown.selectByValue("67");
dropdown.selectByIndex(13);
```

### 2. Auto-Suggest Dropdown
```java
// Type in search box and select from suggestions
searchBox.sendKeys("South");
List<WebElement> suggestions = driver.findElements(By.xpath("//suggestion-xpath"));
for(WebElement suggestion : suggestions) {
    if(suggestion.getText().equals("South Korea")) {
        suggestion.click();
        break;
    }
}
```

### 3. Date Picker Interaction
```java
// Navigate to specific month/year and select date
while(true) {
    String currentMonth = driver.findElement(By.xpath("//month-xpath")).getText();
    String currentYear = driver.findElement(By.xpath("//year-xpath")).getText();
    
    if(currentMonth.equals(targetMonth) && currentYear.equals(targetYear)) {
        break;
    } else {
        driver.findElement(By.xpath("//next-button")).click();
    }
}
```

### 4. Alert Handling
```java
// Handle different types of alerts
Alert alert = driver.switchTo().alert();
System.out.println(alert.getText());
alert.sendKeys("Input text");
alert.accept(); // or alert.dismiss();
```

### 5. Screenshot Capture
```java
// Capture full page screenshot
TakesScreenshot ts = (TakesScreenshot) driver;
File screenshot = ts.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("./screenshots/page.png"));
```

## 🎯 Test Sites Used

The examples use various test websites including:
- Google (google.com)
- Bing (bing.com)
- HDFC Bank (hdfcbank.com)
- Automation Testing Demo Sites
- The Internet (the-internet.herokuapp.com)
- Global SQA (globalsqa.com)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-example`)
3. Commit your changes (`git commit -am 'Add new automation example'`)
4. Push to the branch (`git push origin feature/new-example`)
5. Create a Pull Request

## 📝 Best Practices

- Always use WebDriverManager for automatic driver management
- Implement proper wait strategies instead of Thread.sleep()
- Use Page Object Model for larger projects
- Add proper exception handling
- Close browser instances after test completion
- Use meaningful variable and method names

## 🐛 Troubleshooting

### Common Issues
1. **ChromeDriver version mismatch**: WebDriverManager automatically handles this
2. **Element not found**: Ensure proper wait conditions
3. **Timeout exceptions**: Increase wait time or check element locators
4. **File download issues**: Verify download directory permissions

### Browser Configuration
The examples include configurations for:
- Chrome (with download preferences)
- Firefox (with profile settings)
- Edge (with experimental options)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

If you encounter any issues or have questions:
1. Check the [Issues](https://github.com/yourusername/selenium-webdriver-examples/issues) section
2. Create a new issue with detailed information
3. Provide error logs and system information

---

**Happy Testing! 🚀**

> ⭐ If you find this repository helpful, please consider giving it a star!
