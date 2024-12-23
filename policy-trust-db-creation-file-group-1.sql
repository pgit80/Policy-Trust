-- Creating Database
CREATE DATABASE policy_trust;
USE policy_trust;

-- Admin Table
CREATE TABLE Admin (
    AdminID INT PRIMARY KEY,
    Name VARCHAR(100),
    Email VARCHAR(100)
);

-- Customer Table
CREATE TABLE Customer (
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
CREATE TABLE Policy (
    PolicyID INT PRIMARY KEY,
    Amount DECIMAL(10, 2),
    Premium DECIMAL(10, 2),
    Maturity DATE,
    StartDate DATE,
    Status VARCHAR(20),
    AnnuityTerm VARCHAR(20)
);

-- Claim Table
CREATE TABLE Claim (
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