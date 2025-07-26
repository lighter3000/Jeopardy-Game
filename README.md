# 🎮 Jeopardy Game (Java + MySQL)

A simple but extendable quiz game inspired by Jeopardy – built with Java, MySQL, and JDBC. Designed for learning, fun, and clean architecture.

## 🚀 Features

- Graphical user interface (GUI) for Jeopardy-style questions
- Questions and categories stored in a MySQL database
- Dynamic score calculation based on difficulty
- Modular structure for easy expansion (e.g., randomization, high scores, admin mode)

## 🛠️ Tech Stack

- Java 17
- Maven
- MySQL (compatible with XAMPP)
- JDBC (no external ORM)
- (Later: Swing or JavaFX for the GUI)

## 📁 Project Structure

```text
src/
└── main/
    └── java/
        ├── db/           # Database access (JDBC)
        ├── gui/          # User interface (future)
        ├── logic/        # Game control logic
        ├── model/        # Data models (e.g. Question, Category)
        └── Main.java     # Application entry point

```
Of course the ReadMe is written by ChatGPT 
