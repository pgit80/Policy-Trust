-- Creating Database
CREATE DATABASE policy_trust;
USE policy_trust;

-- User Table: for login purposes
CREATE TABLE Users (
    Username VARCHAR(50),
    Password VARCHAR(50),
    User_Role VARCHAR(10) CHECK (User_Role in ('Customer', 'Admin')) DEFAULT 'Customer'
);

-- Admin Table
CREATE TABLE Admins (
    AdminID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100)
);

-- Customer Table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(15),
    Address VARCHAR(255),
    RegistrationDate DATE,
    AccountStatus VARCHAR(20)
);

-- Schemes Table
CREATE TABLE Schemes (
    SchemeID INT PRIMARY KEY,
    Description TEXT,
    EligibilityCriteria TEXT,
    Benefits TEXT,
    TermsAndConditions TEXT,
    ManagedBy INT,
    FOREIGN KEY (ManagedBy) REFERENCES Admin(AdminID)
);

-- Policy Table
CREATE TABLE Policies (
    PolicyID INT PRIMARY KEY,
    Amount DECIMAL(10, 2),
    Premium DECIMAL(10, 2),
    Maturity DATE,
    StartDate DATE,
    Status VARCHAR(20),
    AnnuityTerm VARCHAR(20)
);

-- Claim Table
CREATE TABLE Claims (
    ClaimID INT PRIMARY KEY,
    ClaimDate DATE,
    Description TEXT,
    Amount DECIMAL(10, 2),
    Status VARCHAR(20),
    ClaimedBy INT,
    CreatedBy INT,
    FOREIGN KEY (ClaimedBy) REFERENCES Customer(CustomerID),
    FOREIGN KEY (CreatedBy) REFERENCES Admin(AdminID)
);
