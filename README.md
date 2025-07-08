# 📚 Quantum Book Store

**Quantum Book Store** is a Java console-based project that simulates a basic online bookstore. It is structured to be modular and easily extensible.

---

## 📦 Book Types

The system supports three book types:

- **PaperBook**: Has stock and can be shipped.
- **EBook**: Has a file type and is delivered via email.
- **DemoBook**: Demo books not for sale.

---

## 🚀 Features

- Add books to inventory (`ISBN`, title, year, price).
- Remove books that are outdated based on a given number of years.
- Buy a book using its ISBN and appropriate info:
  - **PaperBook**: needs quantity and address.
  - **EBook**: needs email.
- Prevent buying DemoBooks.
- Handles invalid data inputs with validation.
- Designed for extensibility without changing existing classes.

---

## 🧱 Structure

The system uses a layered structure with packages:

this is the screenshots of the run

![Screenshot 2025-07-08 225909](https://github.com/user-attachments/assets/958323a3-926d-4927-a625-b90f1c072051)


![Screenshot 2025-07-08 225938](https://github.com/user-attachments/assets/770ef4f4-b6de-4471-9721-22782aec839e)



![Screenshot 2025-07-08 230007](https://github.com/user-attachments/assets/78814cc6-ab15-42d1-ba79-94605af8ae17)


