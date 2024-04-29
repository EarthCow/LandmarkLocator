# Landmark Locator

## Overview
Landmark Locator is a Java-based computer vision project that utilizes Google Cloud Vision to identify landmarks in images. Once a landmark is identified, it leverages the Google Maps API to find places of interest near that landmark.

## Features
- Utilizes Google Cloud Vision to identify landmarks in images.
- Utilizes Google Maps API to find places near identified landmarks.
- Provides detailed information about identified landmarks and nearby places.

## Getting Started
To get started with Landmark Locator, follow these steps:

1. **Clone the Repository**: Clone the Landmark Locator repository to your local machine.

   ```bash
   git clone https://github.com/EarthCow/LandmarkLocator.git
   ```

2. **Set up Google Cloud Vision Authentication**:
   - In order for Landmark Locator to work, you need to set up your own Google Cloud Vision authentication or use the `key.json` file provided in the repository.
   - Set an environmental variable named `GOOGLE_AUTHENTICATION_CREDENTIALS` to point to your authentication JSON file. You can do this by running the following command in your terminal:

     ```bash
     export GOOGLE_AUTHENTICATION_CREDENTIALS=/path/to/your/key.json
     ```

3. **Build and Run the Application**: Navigate to the project directory and build/run the application.

   ```bash
   cd LandmarkLocator
   mvn clean install
   java -jar target/LandmarkLocator.jar
   ```

4. **Select an Image**: Once the application is running, select an image from the provided dataset.

5. **View Results**: After the image is processed, view the identified landmark and nearby places.

## License
This project is licensed under the [MIT License](LICENSE).

## Acknowledgements
- Google Cloud Vision API
- Google Maps API
