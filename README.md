# 🐞 Mastermind Bug Hunt!

## 🎯 Task Overview

You've been provided with a working Java implementation of the classic game **Mastermind**. However, two subtle bugs have been introduced intentionally. Your task is to identify these hidden bugs by writing test cases for the methods in the program.

## 🧩 What is Mastermind?

In Mastermind, a secret code is generated consisting of four digits, each ranging from 1 to 6. The player's goal is to guess this secret code. After each guess, the game provides two hints:

- How many digits are correct and in the **exact position**.
- How many digits are correct but in the **wrong position**.

Your provided Java code handles these hints through clearly defined methods.

## 🔍 How to Find the Bugs

Two functions have subtle bugs:
- The bugs might **not affect every guess** but will produce incorrect results for **specific cases**.
- Your job is to write Java test cases that can reveal these bugs.

To find these bugs, follow these steps:

1. **Understand the Code:**
   - Read through the provided `Mastermind` Java file.
   - Make sure you understand what each function should do.

2. **Write Your Test Cases:**
   - For each method (especially `isValidGuess`, `convertGuessToArray`, `countCorrectPositions`, and `countCorrectNumbers`), write multiple test cases.
   - Think about edge cases:
     - Guesses with repeated digits.
     - Guesses at boundary conditions (e.g., minimum and maximum allowed digits).

3. **Identify the Bugs:**
   - Run your tests.
   - Look carefully at test failures. Investigate why they failed.
   - Clearly document which methods have bugs, what input revealed the bugs, and explain why the bugs occurred.

## 📋 Submission

Your submission should include:

- Show me your testing code, and which two functions have the bugs

## 💡 Tips

- **Focus on clarity:** Your tests should clearly indicate what's being tested.
- **Test systematically:** Don’t guess randomly; think carefully about boundary and edge cases.
- **Discuss and Collaborate:** Talk to classmates, compare your ideas, but submit your own work.

---

Happy hunting! 🐛🔍

