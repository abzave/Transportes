# Transportation Services Management System in Java

This project simulates the transportation services system of the Costa Rica Institute of Technology, which allows to manage drivers, vehicules and trips. The goal of the project is to learn the principles of Object Oriented Programming.

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Requirements](#requirements)
4. [How to Compile and Run](#how-to-compile-and-run)
5. [Usage](#usage)

## Project Overview

This transportation services management system simulates to handle trips, passangers, drivers and vehicules for the Costa Rica Institute of Technology. The application uses Object Oriented Programming to model real world services that are being provided.

## Features

- **User Authentication**: Requires users to have an account in order to be able to use the application.
- **User Groups**: Users are given access only to the actions required for their role. The groups availables are: administrator and secretary.
- **Drivers Management**: Allows users to create drivers and assign drivers to trips.
- **Vehicule Management**: Allows users to create vehicules and assign drivers to trips.
- **Trip Management**: Allows users to create trips, assign a driver, assign a vehicule and assign passangers.
- **Passanger Management**: Allows users to register passangers into a trip.
- **Reporting**: Displays graphs to administrators with information about the amount of trips by drivers, and by departments.
- **Graphic User Interface**: Users can interact with the application through a GUI.

## Requirements

- **Java Virtual Machine**: A Java Virtual Machine supporting Java 8 or higher.
- **GUI with JavaFX**: Uses JavaFX for providing a GUI.

## How to Compile and Run

### Step 1: Clone the repository

``` bash
git clone https://github.com/abzave/Transportes.git
cd Transportes
```

### Step 2: Compile the project

``` bash
javac -cp *.jar aplicacion/*.java library/*.java personal/*.java ui/*.java util/*.java
```

### Step 3: Run the program

``` bash
java aplicacion.Main
```

## Usage

1. Log into the application using your username and password.
2. If the user is administrator the menu will be as follows:
    1. Register a new driver
        1. Enter the driver's name
        2. Enter the driver's national ID
        3. Enter the driver's phone number
        4. Enter the driver's email
        5. Enter the amount of driving licenses hold by the driver
        6. Click on add license for each license that the driver holds
            1. Enter the license type
            2. Enter the license issuance date
            3. Enter the license expiration date
            4. Click register
        7. Click register
    2. Register a new vehicule
        1. Enter the vehicule's license plate
        2. Enter the vehicule's year
        3. Enter the vehicule's color
        4. Enter the vehicule's brand
        5. Enter the vehicule's VIN number
        6. Enter the vehicule's location
        7. Enter the vehicule's passanger amount
        8. Enter the vehicule's millage
        9. Enter the vehicule's amount of maintenance visits
        10. Click on add license for each maintenance visit the vehicule has had
            1. Enter the type of maintenance visit
            2. Enter the date of the maintenance visit
            3. Enter the millage the vehicule had at the time of the maintenance visit
            4. Enter a description of the maintenance visit
            5. Click add company
                1. Enter the company name
                2. Enter the company's legal ID
                3. Enter the company's phone number
                4. Click add address
                    1. Enter the province
                    2. Enter the canton
                    3. Enter the district
                    4. Enter the address line
                    5. Click register
                5. Click register
            6. Click register
        11. Click register
    5. List trips
    6. Approve trip request
        1. Click all the trips to be approved
        2. Click the driver or drivers that assigned to the trip
        3. Click the vehicule assigend to the trip 
    7. Register a new user
        1. Enter the user's name
        2. Enter the user's nation ID
        3. Enter the user's phone number
        4. Enter the department that the user belongs to
        5. Enter the user's email
        6. Click register
    8. View report
        1. Top 5 assigned drivers
        2. Top 5 departments
3. If the user is secretary the menu will be as follows:
    1. Register passanger
        1. Enter the passanger's name
        2. Enter the passanger's national ID
        3. Enter the passanger's phone number
        4. Enter the passanger's email
        5. Click register
    2. Request trip
        1. Enter the starting province
        2. Enter the stating canton
        3. Enter the stating district
        4. Enter the stating address line
        5. Enter the destination province
        6. Enter the destination canton
        7. Enter the destination district
        8. Enter the destination address line
        9. Enter the starting date
        10. Enter the returning date
        11. Enter the vehicule's initial millage
        12. Click on the passanger names that will be on the trip
        13. Click accept
    3. List Trips
        1. Click on select filter type
            1. Select the type of filter. Options are: date, destination, request in progress, approved, denied.
        3. Click filter
