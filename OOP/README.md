# OOP Project: DICOM!
The purpose of this code is to input and process medical images in the form of DICOM files (.dcm files) and extract the patient and image data. The program will then use a graphical user interface (GUI) to facilitate user interaction with the information collected.  

## Description
This project was developed using Java and utilizes the PixelMed library to handle DICOM files and extract important patient and image information. The GUI is built using Java Swing framework to upload and view information from DICOM files. 

DicomRFeader.java

The DicomReader class has methods to read patient and image information from the dicom files. There is a helper method which aids ensuring DICOM attributes that are strings can be extracted. 

DicomInfo.java, DicomPatientInfo.java, & DicomImageInfo.java

The parent class DicomInfo was used to ensure that the study name is attached to both child classes DicomPatientInfo and DicomImageInfo. Both child classes have accessor and mutator methods that ensure the respective data is not unnecessarily altered when accessing. 

DicomUI.java & Runner.java

The DIcomUI class contains the implementation of Java Swing to create the GUI. The Runner class then executes the GUI. 

### Dependencies
The library PixelMed is needed to run the program. 
Link to download: https://www.dclunie.com/pixelmed/software/20240221_current/pixelmed.jar 

### Executing program
Gradle is needed to execute the program. 

Terminal Commands:
1. gradle clean
2. gradle build
3. java -cp "build/libs/Runner.jar;libs/pixelmed.jar" dicom.Runner


### Limitations
The code is limited to files that are in DICOM form. 

## Author Information
Adrianna Con
acon@uoguelph.ca
Student ID: 1079858

## References
- https://www.saravanansubramanian.com/blogmakingsenseofdicomfile/ 
- https://www.dclunie.com/pixelmed/software/javadoc/com/pixelmed/dicom/AttributeList.html
- https://www.youtube.com/watch?v=5o3fMLPY7qY&ab_channel=AlexLee 
- ChatGPT was used to create the build.gradle file and to improve the README.md file
- Resources (lecture slides, lab material, examples) from Fall 2023 CIS*2430 by Dr. Judi McCuaig was used


