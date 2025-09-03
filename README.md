# 📚 Bookshop Management System

> A comprehensive Java-based bookshop management solution developed for **22COA256: Object-oriented Programming** at Loughborough University

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)](https://github.com/)
[![University](https://img.shields.io/badge/Loughborough_University-7C2855?style=for-the-badge)](https://www.lboro.ac.uk/)

## 📖 About The Project

Welcome to my Bookshop Management System! This project was born out of a desire to create a practical, real-world application that demonstrates core Object-Oriented Programming principles while solving actual business needs. As someone passionate about both literature and technology, building a system that bridges these worlds was particularly exciting.

The system handles the day-to-day operations of a modern bookshop, managing everything from inventory tracking to customer purchases, all while maintaining a clean separation between different user roles and responsibilities.

### ✨ Key Highlights

- **🎯 Purpose-Built**: Designed specifically for small to medium bookshops looking for a streamlined management solution
- **🔐 Role-Based Access**: Separate interfaces for administrators and customers with appropriate permissions
- **📊 Smart Inventory**: Real-time stock tracking with automatic updates after purchases
- **🛒 Shopping Experience**: Full shopping basket functionality with credit-based payment system
- **🔍 Advanced Search**: Multiple search and filter options for finding the perfect book

## 🚀 Features

### 👨‍💼 Admin Capabilities
- **View Inventory**: Browse all books sorted by quantity to identify low stock items
- **Add New Books**: Seamlessly add new books to inventory with comprehensive details
- **Stock Management**: Track paperbacks, ebooks, and audiobooks in one unified system

### 🛍️ Customer Features
- **Browse Catalog**: View all available books sorted by price for easy comparison
- **Shopping Basket**: Add multiple items, view basket contents, and manage selections
- **Smart Checkout**: Credit-based payment system with automatic receipt generation
- **Search & Filter**: 
  - Quick barcode lookup for specific books
  - Filter audiobooks by listening length
  - Advanced search capabilities
- **Basket Management**: Clear entire basket with one click

### 📚 Book Types Supported

| Type | Special Attributes |
|------|-------------------|
| 📖 **Paperback** | Pages, Condition (New/Used) |
| 💻 **Ebook** | Pages, Format (EPUB/MOBI/PDF) |
| 🎧 **Audiobook** | Listening Length, Format (MP3/WMA/AAC) |

## 🏗️ Architecture

The project follows a robust Object-Oriented design with clear separation of concerns:

```
BookManagement/
├── 📁 Main/
│   └── UserInterface.java       # Main entry point & UI logic
├── 📁 books/
│   ├── book.java                # Abstract base class
│   ├── paperback.java           # Paperback implementation
│   ├── ebook.java               # Ebook implementation
│   ├── audiobook.java           # Audiobook implementation
│   └── bookmanager.java         # Book management operations
├── 📁 user_files/
│   ├── User.java                # Abstract user class
│   ├── Admin.java               # Admin implementation
│   ├── Customer.java            # Customer implementation
│   ├── Address.java             # Address management
│   ├── shoppingBasket.java      # Basket functionality
│   └── usermanager.java         # User management operations
└── 📁 data_files/
    ├── Stock.txt                # Book inventory data
    └── UserData.txt             # User account data
```

### 📐 Class Diagram

![Class Diagram](./class-diagram.pdf)

The UML class diagram above illustrates the complete object-oriented architecture of the system:

- **Abstract Classes**: `Book` and `User` serve as base classes with common attributes and methods
- **Inheritance Hierarchy**: 
  - Book → {Paperback, Ebook, Audiobook}
  - User → {Admin, Customer}
- **Manager Classes**: `bookmanager` and `usermanager` handle operations and data persistence
- **Shopping Logic**: `shoppingBasket` manages the customer's shopping experience
- **Relationships**: Clear associations between User types and their respective capabilities

### 🎨 Design Patterns Used

- **Inheritance Hierarchy**: Abstract base classes for `Book` and `User` with specialized implementations
- **Enum Types**: Used for book formats, languages, genres, and conditions ensuring type safety
- **File-Based Persistence**: CSV format for easy data management and portability
- **Separation of Concerns**: Clear division between UI, business logic, and data layers

## 💻 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Eclipse IDE (recommended) or any Java-compatible IDE
- Windows OS (for full compatibility)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Saipraneet173/Books-Ordering-System.git
   cd BookManagement
   ```

2. **Open in Eclipse**
   - File → Import → Existing Projects into Workspace
   - Select the BookManagement directory
   - Click Finish

3. **Run the application**
   - Navigate to `Main/UserInterface.java`
   - Right-click → Run As → Java Application

### 🎮 Quick Start Guide

1. **Launch the application** and select your role (Admin/Customer)
2. **Choose your User ID** from the displayed list
3. **Navigate the menu** using number selections
4. **For Customers**: Browse → Add to Basket → Checkout
5. **For Admins**: View inventory → Add new books as needed

## 📊 Sample Data

The system comes pre-loaded with sample data to get you started:

### Users
- **Admin**: user1 (ID: 101)
- **Customers**: user2-4 (IDs: 102-104) with varying credit balances

### Books
15 diverse books including bestsellers like "A Promised Land", technical books like "Cyber Security", and business titles like "Intelligent Investor"

## 🛠️ Technical Details

### Data Validation
- ✅ 8-digit barcode verification
- ✅ Stock availability checking
- ✅ Credit balance validation
- ✅ Duplicate barcode prevention

### Error Handling
- Comprehensive error messages for user guidance
- Graceful handling of invalid inputs
- File I/O exception management

### Performance Features
- Efficient sorting algorithms for price and quantity
- Optimized search functionality
- Memory-efficient data structures

## 🎯 Learning Outcomes

Through this project, I've strengthened my understanding of:

- **Object-Oriented Principles**: Encapsulation, inheritance, polymorphism, and abstraction
- **File Handling**: Reading from and writing to CSV files in Java
- **User Interface Design**: Creating intuitive command-line interfaces
- **Data Structures**: Working with Lists, ArrayLists, and custom objects
- **Software Design**: Planning and implementing a multi-layered application
- **Error Management**: Implementing robust validation and error handling

## 🤝 Acknowledgments

- **Dr. Hossein Nevisi** - Module coordinator and project supervisor
- **Loughborough University** - For providing the educational framework
- **Stack Overflow Community** - For invaluable debugging assistance
- **Oracle Java Documentation** - For comprehensive API references

## 📝 License

This project is submitted as coursework for academic assessment. Please respect academic integrity guidelines if referencing this work.

## 📦 Project Deliverables

This repository contains all required coursework components:

- ✅ **Source Code**: All Java files with meaningful comments
- ✅ **Data Files**: UserAccounts.txt and Stock.txt with sample data
- ✅ **Class Diagram**: UML diagram (ClassDiagram.jpg) showing OO design
- ✅ **Executable**: Can be compiled into bookshop.jar
- ✅ **Documentation**: This README and inline code documentation

## 🔮 Future Enhancements

While the current implementation meets all coursework requirements, potential improvements could include:

- 🖥️ GUI implementation using JavaFX or Swing
- 🗄️ Database integration (MySQL/PostgreSQL)
- 📧 Email notifications for order confirmations
- 📈 Sales analytics and reporting features
- 🌐 Web-based interface for remote access
- 🔒 Enhanced security with password authentication

## 📬 Contact

**Developer**: [Saipraneet Darla]  
**Course**: 22COA256 - Object-oriented Programming  
**Institution**: Loughborough University  
**Academic Year**: 2023/2024  

---

<div align="center">
  
**Made with ❤️ and ☕ during late-night coding sessions**

*"Books are a uniquely portable magic." - Stephen King*

</div>
