# H5 - Use testing library with TDD methodology

Do the same as H4 but using a testing library and TDD as metology.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

This is a Kotlin project. In order to run the project, you need to have been already installed the following technologies:

1. Install [Java](https://www.java.com/es/download/).
2. Install [JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
3. Install [Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html)
4. Install [Gradle](https://gradle.org/install/).

### Build the library

1. Make a clone of the repository.
2. Locate in the project directory and run:
    ```bash
    gradle build
    ```

## Running the tests

To run the tests you only need to execute the following command:

```bash
gradle test
```

## Author

The author of this repository is Mikhael Santos Fernández (1088621).

## About TDD

TDD or Test Driven Development is a test methodology that emphasizes testing first and making the production code after. The workflow in this methodology consists of basically repeating the following two steps until there is no more code to write:

1. Make a test of a function or class that is not already implemented.
2. Write the implementation code.

## Useded Gradle commands

- `gradle test`: It's to execute tests.
- `gradle build`: Assembles and tests this project. Also create a serie of documents including tests in `build/reports/tests/test/index.html`.
- `gradle run`: Executes the project as an app. In order to choose the entry point of the app go to `build.gradle.kts` and change the value of `application.mainClassName`.

## References

- [Test plan](https://docs.google.com/document/d/1jgk5OGaXv2GIYBWSLL3pl3Mzz2hDIkeQQeTGL3oAzJ4/edit?usp=sharing)
