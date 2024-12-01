# FITCORE Gym Management System

## Overview

FITCORE is a Java-based Gym Management System designed to simplify gym operations by automating processes such as member registration, trainer assignment, and workout scheduling. It offers a user-friendly interface built using Java Swing and robust backend support with MySQL, ensuring efficiency and scalability.

## Features

- **User Login System**:
  - Separate logins for Admins, Trainers, and Members.
- **Member and Trainer Management**:
  - Add, update, or delete member and trainer profiles, including personal information, fitness goals, and schedules.
- **Workout Scheduling**:
  - Customized workout plans for members with automated trainer allotment based on availability and fitness goals.
- **Admin Dashboard**:
  - Manage user profiles, schedules, and classes.
  - Generate reports for gym activities.
- **Trainer Dashboard**:
  - View assigned members and schedules.
- **Member Dashboard**:
  - Update profiles, view workout plans, and track progress.

## Technology Stack

- **Code Editor**: Visual Studio Code
- **Frontend**: Java Swing, AWT
- **Backend**: MySQL for database management
- **Programming Language**: Java

## Project Structure

The project is organized into the following folders:

- `src`: Contains the source code for the application.
  - `AdminDashboard.java`: Admin dashboard functionality.
  - `TrainerDashboard.java`: Trainer-specific operations.
  - `MemberDashboard.java`: Member-specific operations.
  - Other utility classes and panels for the GUI.
- `images`: Contains images used in the GUI, including interface designs like `ADMINLOGIN.png`, `MEMBERREGISTER.png`, and others.
- `bin`: Contains compiled `.class` files.

> The project uses Visual Studio Code for development and follows a modular structure to separate concerns.

## System Flow

### Data Flow Diagram

1. **User Input**:
   - Inputs include login credentials, registration details, and workout preferences.
2. **Validation**:
   - Input is validated to ensure accuracy and completeness.
3. **Processing**:
   - Business logic processes input for trainer allocation and schedule creation.
4. **Database Interaction**:
   - MySQL database stores and retrieves member and trainer data.
5. **Result Display**:
   - Results are displayed on intuitive dashboards for members, trainers, and admins.

### Block Diagram

![Block Diagram](images/structure.png)  
*Illustrates the flow of operations from user interaction to database management and result visualization.*

## Objectives

- Simplify gym management through automation.
- Provide a scalable, user-friendly system to improve operational efficiency.
- Enable easy management of members, trainers, and workout schedules.

## Installation and Usage

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/Itz-Om17/GYM-Management-System.git

