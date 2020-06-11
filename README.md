# H5 - Use testing library with TDD methodology

## Statement

Do the same as H4 but using a testing library and TDD as metology.

## TDD's rules

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

## Commands

- `gradle test`: It's to execute tests.
- `gradle build`: Assembles and tests this project. Also create a serie of documents including tests in `build/reports/tests/test/index.html`.
- `gradle run`: Executes the project as an app. In order to choose the entry point of the app go to `build.gradle.kts` and change the value of `application.mainClassName`.

