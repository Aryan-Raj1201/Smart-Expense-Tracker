# 💰 Smart Expense Tracker for Students (Core Java)

A feature-rich, menu-driven **Core Java expense tracking system** designed for students to manage daily spending, monitor monthly budgets, generate reports, and maintain persistent records using file handling.

This project is not just a basic CRUD program.  
It is a **budget-aware personal finance system** built with strong OOP design and real-world usability.

---

## 🚨 Why This Project Exists

Students spend money daily on:

- Food & snacks
- Travel & transportation
- Study materials
- Shopping
- Subscriptions & entertainment
- Health and emergency needs

But most students don’t track their spending properly.

This leads to:

- Overspending
- Poor budgeting habits
- No monthly expense awareness
- Money shortage before month-end

👉 This project solves that real-world student problem using pure Java.

---

## 🎯 What This System Does (At a Glance)

✔ Tracks daily expenses with date and category  
✔ Auto-generates unique expense IDs  
✔ Stores expenses permanently using file handling  
✔ Allows update and deletion of expenses  
✔ Calculates total and monthly expenses  
✔ Generates category-wise summaries  
✔ Detects budget exceed conditions  
✔ Warns when 80% budget is reached  
✔ Sorts expenses by amount or date  
✔ Exports monthly report into a text file  

This is not just a program.  
This is a **personal finance tracker for students**.

---

## 🏗 System Architecture (High-Level)

User Input (Console Menu)
│
├── Expense Creation Module
│ ├── Title, Amount, Category, Date
│ └── Auto ID Generation
│
├── Expense Manager (Core Logic)
│ ├── Add / Update / Delete
│ ├── Sorting and Filtering
│ ├── Monthly Analytics
│ └── Budget Monitoring
│
├── File Storage Engine
│ ├── Save expenses to expenses.txt
│ └── Load expenses at program startup
│
└── Report Generator
├── Monthly Report Export
└── Category Summary Report

---

## 📥 Expected Inputs

The user provides:

- Student name
- Monthly budget
- Expense title
- Expense amount
- Expense category
- Expense date (YYYY-MM-DD)

Supported categories:

- FOOD
- TRAVEL
- STUDY
- SHOPPING
- HEALTH
- ENTERTAINMENT
- OTHER

---

## 📤 Outputs Generated

This system produces multiple useful outputs:

### 1️⃣ Expense Records (Permanent Storage)

All expenses are saved into:

expenses.txt

So even if the program is closed, expenses are not lost.

---

### 2️⃣ Budget Monitoring Output

Shows monthly spending compared to budget:

- ✔ Within budget
- ⚠ Warning at 80% usage
- ❌ Budget exceeded alert

---

### 3️⃣ Category-Wise Summary

Provides spending breakdown per category such as:

FOOD : ₹1200
TRAVEL : ₹500
STUDY : ₹900

---

### 4️⃣ Monthly Report Export (File Output)

A report file is generated like:

MonthlyReport_2026_3.txt

This file contains:

- All expenses of the month
- Total monthly spending

---

## 🧠 Smart Features Included

This project goes beyond basic expense tracking.

### 🔥 Auto ID System
Each expense is assigned a unique ID automatically:

Example:

ID: 1 | Pizza | FOOD | ₹250
ID: 2 | Auto | TRAVEL | ₹120

---

### ⚠ Budget Alert System
- Warning when 80% budget is reached
- Alert when budget is exceeded

This makes it a **budget-aware expense tracker**.

---

### 📊 Sorting & Analytics
- Sort by amount
- Sort by date
- Highest expense
- Lowest expense
- Monthly totals

---

## 🧪 Validation Philosophy

This project ensures:

- No invalid categories are accepted
- No duplicate storage errors occur
- Expense ID updates/deletes are safe
- Data is always saved after every operation

The goal is to ensure:

✔ Accuracy  
✔ Persistence  
✔ Reliability  

---

## 🛠️ Technologies Used

- **Core Java**
- **Object-Oriented Programming**
- **ArrayList Collection Framework**
- **File Handling (BufferedReader, FileWriter)**
- **LocalDate API**
- **Exception Handling**
- **Menu-Driven Console Interface**

---

## 📁 Project Structure

ExpenseTracker/
├── src/
│ ├── Main.java
│ ├── Expense.java
│ ├── ExpenseManager.java
│ ├── FileHandler.java
│ ├── Category.java
│ └── Student.java
├── expenses.txt
└── README.md

---

# ▶ How to Run

## 1️⃣ Compile the Project
Go inside `src` folder:

```bash
javac *.java

2️⃣ Run the Program

java Main

```

## 🧪 Example Run (Demo)

```bash
===== Smart Expense Tracker =====
Enter your name: Shailja
Set your monthly budget: 5000

Expense added successfully with ID: 1
Expense added successfully with ID: 2

Total spent in 3/2026: ₹370.0
Budget: ₹5000.0
✔ You are within your budget.
```
---

## 🏆 Why This Project Stands Out

Most student projects are:

Hardcoded
Not persistent
Not practical

This system is designed like a real application:

Persistent data storage
Update/delete support
Budget intelligence
Report generation
Sorting + analytics
Clean modular OOP design

This is exactly the type of project that demonstrates real Java skill.

---

## 🚀 Future Improvements

Planned upgrades include:

GUI using Java Swing / JavaFX
Multi-user login system
Export report to CSV/PDF
Graph-based analytics
Database integration (MySQL)

---

## 📌 Resume Description (Recommended)

Smart Expense Tracker for Students (Core Java Project)
Developed a menu-driven Java application to manage student expenses with category filtering, sorting, budget alerts, and monthly report export functionality. Implemented persistent storage using file handling and applied OOP principles for modular system design.

---

## 👤 Author

Aryan Raj
B.Tech — Artificial Intelligence & Machine Learning
Java & DSA Learner | VIT Bhopal University

---

## 🧾 Final Note

This project is not about making a fancy interface.
It is about building a real system that solves a real problem using:

OOP design
clean logic
reliable storage
smart features

Because even simple applications become powerful when they are purposeful.







