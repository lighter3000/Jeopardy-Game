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
    ├── java/
        ├── db/           # Database access (JDBC)
        ├── gui/          # User interface (future)
        ├── logic/        # Game control logic
        ├── model/        # Data models (e.g. Question, Category)
        └── Main.java     # Application entry point
    └── resources/

```
Of course the ReadMe is written by ChatGPT, will be manually written later on



## TODO

- Admin Window (currently working on it)
- Arduino Connection for Buttons
- ~Rework QuestionToCategory (instead of numbers being the connection, let it be words)~ -- Done
- More Topics and Questions
- ~Players and Pointsystem (being displayed either on admin Window or somewhere else)~ -- Done
- Make it possible to add points to the players via AdminWindow (currently working on it)


## Future Ideas if I want to (for this project)

- Dynamically change the size of the CategoriesLabels depending on the amount (and therefore increase the amount of categories)
