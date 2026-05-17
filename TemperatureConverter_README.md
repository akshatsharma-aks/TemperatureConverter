# 🌡️ Temperature Converter — Java Console Application

> A clean, menu-driven Java console application to convert temperatures between Celsius and Fahrenheit.
> Built as part of a Software Development Internship.

---

## 🧾 Project Overview

This **Temperature Converter** is an interactive console application that lets users convert temperatures between Celsius and Fahrenheit using proven mathematical formulas. It features a polished menu interface, robust input validation, and clean formatted output — all in a single, well-commented Java file.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🔄 Celsius → Fahrenheit | Convert any Celsius value to Fahrenheit |
| 🔄 Fahrenheit → Celsius | Convert any Fahrenheit value to Celsius |
| 🔢 Precise Output | Results formatted to 2 decimal places |
| 🛡️ Input Validation | Handles letters, symbols, empty input — no crashes |
| 🔁 Multiple Conversions | Converts repeatedly until the user exits |
| 🎨 Formatted UI | Box-drawing characters for a professional console look |

---

## 📐 Conversion Formulas

```
Celsius → Fahrenheit:    F = (C × 9/5) + 32
Fahrenheit → Celsius:    C = (F − 32) × 5/9
```

---

## 🗂️ Project Structure

```
TemperatureConverter/
│
├── src/
│   └── TemperatureConverter.java   # Complete application — single file
│
└── README.md                       # Project documentation
```

---

## ⚙️ Requirements

- Java JDK 8 or higher
- Any terminal / command prompt

---

## 🚀 How to Compile and Run

```bash
# Step 1: Navigate into the src folder
cd TemperatureConverter/src

# Step 2: Compile
javac TemperatureConverter.java

# Step 3: Run
java TemperatureConverter
```

---

## 🖥️ Sample Console Output

```
  ╔════════════════════════════════════════════════╗
  ║         TEMPERATURE CONVERTER  v1.0            ║
  ║       Internship Project  —  Java Console      ║
  ╚════════════════════════════════════════════════╝
  Supports: Celsius ↔ Fahrenheit
  Output precision: 2 decimal places

  ┌──────────────────────────────────┐
  │            MAIN MENU             │
  ├──────────────────────────────────┤
  │  1.  Celsius  →  Fahrenheit      │
  │  2.  Fahrenheit  →  Celsius      │
  │  3.  Exit                        │
  └──────────────────────────────────┘
  Enter your choice: 1

  ════════════════════════════════════════════
   CELSIUS  →  FAHRENHEIT
  ════════════════════════════════════════════
  Enter temperature in Celsius    : 100

  ┌──────────────────────────────────────────┐
  │               RESULT                     │
  ├──────────────────────────────────────────┤
  │  Input  (Celsius   ) : 100.00 °C         │
  │  Output (Fahrenheit) : 212.00 °F         │
  └──────────────────────────────────────────┘

  Enter your choice: 2

  ════════════════════════════════════════════
   FAHRENHEIT  →  CELSIUS
  ════════════════════════════════════════════
  Enter temperature in Fahrenheit : 98.6

  ┌──────────────────────────────────────────┐
  │               RESULT                     │
  ├──────────────────────────────────────────┤
  │  Input  (Fahrenheit) : 98.60 °F          │
  │  Output (Celsius   ) : 37.00 °C          │
  └──────────────────────────────────────────┘

  Enter your choice: abc
  ✖  Invalid choice! Please select 1, 2, or 3.

  Enter your choice: 1
  Enter temperature in Celsius    : hello
  ✖  Invalid input! Please enter a numeric value (e.g. 37.5 or -10).
  Enter temperature in Celsius    : -40

  ┌──────────────────────────────────────────┐
  │               RESULT                     │
  ├──────────────────────────────────────────┤
  │  Input  (Celsius   ) : -40.00 °C         │
  │  Output (Fahrenheit) : -40.00 °F         │
  └──────────────────────────────────────────┘

  Enter your choice: 3

  ════════════════════════════════════════════
   Thank you for using Temperature Converter!
   Have a great day. Goodbye! 👋
  ════════════════════════════════════════════
```

---

## 🧠 Concepts Demonstrated

- **Scanner** — Reading console input
- **Switch-Case** — Menu navigation
- **While Loop** — Repeat-until-exit pattern
- **Exception Handling** — `try-catch` for `NumberFormatException`
- **Methods** — Clean separation of logic into reusable functions
- **String Formatting** — `String.format()` for precision and alignment
- **Type Conversion** — `double` arithmetic for accurate results
- **Naming Conventions** — camelCase methods, meaningful variable names

---

## 👤 Author

**[Your Full Name]**
B.Tech CSE — [Year]
[Your College Name]
GitHub: [@yourusername](https://github.com/yourusername)

---

## 📄 License

Open source — free to use for learning and internship submission.
