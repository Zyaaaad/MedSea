# Med Sea Ecosystem

A JavaFX-based ecosystem simulation that demonstrates the interaction of climate, fishing activities, and pollution in the Mediterranean Sea.
## Prerequisites

Before running the project, ensure you have the following installed:

    Java Development Kit (JDK) 19 or later
    Apache Maven

## Project Setup
### Steps to Download and Run

    Clone the repository:

git clone https://github.com/Zyaaaad/MedSea.git  
cd MedSea

Verify Maven is installed by running:

mvn -v

Build the project using Maven:

mvn clean install

Run the application:

    mvn javafx:run  

## Notes

    Ensure you have an active internet connection for Maven to download dependencies on the first run.
    The JavaFX dependencies are configured for version 19.0.2 in the pom.xml. If your JDK version does not match, adjust the source and target in the maven-compiler-plugin section to match your JDK.

## Issues

If you encounter the error main class not found, double-check that your pom.xml file includes the following:

<configuration>  
    <mainClass>com.example.medsea/com.example.medsea.HelloApplication</mainClass>  
</configuration>  

Also, verify that the resources folder is properly set up in your IDE.
## Project Structure

MedSea/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   └── com.example.medsea/  
│   │   │       ├── HelloApplication.java  
│   │   │       ├── HelloController.java  
│   │   ├── resources/  
│   │   │   ├── hello-view.fxml  
│   │   │   ├── Mediterranean.jpg  
├── pom.xml

## License

This project is licensed under the MIT License.