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

- ~Admin Window (currently working on it)~ (Looks finished)
- ~Rework QuestionToCategory (instead of numbers being the connection, let it be words)~ -- Done
- ~Players and Pointsystem (being displayed either on admin Window or somewhere else)~ -- Done
- ~Make it possible to add points to the players via AdminWindow~ -- Done, but can be rewritten (GameWindow, AdminWindow, QuestionLabel)
- ~Made it so if something went wrong, you can remove the points~ -- Done

- Make the code better (f.e. AdminWindow and GameWindow are inherited by another super class)
- Rewrite the communications between classes with an interface (need to see if its worth it)
- More Topics and Questions (Currently working on it)
- Arduino Connection for Buttons



## Future Ideas if I want to (for this project)

- Dynamically change the size of the CategoriesLabels depending on the amount (and therefore increase the amount of categories)
