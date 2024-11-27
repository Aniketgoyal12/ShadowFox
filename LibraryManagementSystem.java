import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.init();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Add Book");
            System.out.println("4. View Books");
            System.out.println("5. Recommend Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> User.register();
                case 2 -> User.login();
                case 3 -> Book.addBook();
                case 4 -> Book.viewBooks();
                case 5 -> Book.recommendBooks();
                case 6 -> {
                    Database.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
class Database {
    private static Connection connection;

    public static void init() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, password TEXT)");
                stmt.execute("CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY, title TEXT, author TEXT, genre TEXT)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class User {
    private static String currentUser;

    public static void register() {
        System.out.print("Enter username: ");
        String name = LibraryManagementSystem.scanner.nextLine();
        System.out.print("Enter password: ");
        String password = LibraryManagementSystem.scanner.nextLine();

        try (PreparedStatement stmt = Database.getConnection().prepareStatement("INSERT INTO users (name, password) VALUES (?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void login() {
        System.out.print("Enter username: ");
        String name = LibraryManagementSystem.scanner.nextLine();
        System.out.print("Enter password: ");
        String password = LibraryManagementSystem.scanner.nextLine();

        try (PreparedStatement stmt = Database.getConnection().prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                currentUser = name;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class Book {
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = LibraryManagementSystem.scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = LibraryManagementSystem.scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = LibraryManagementSystem.scanner.nextLine();

        try (PreparedStatement stmt = Database.getConnection().prepareStatement("INSERT INTO books (title, author, genre) VALUES (?, ?, ?)")) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBooks() {
        try (Statement stmt = Database.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                System.out.printf("ID: %d, Title: %s, Author: %s, Genre: %s%n",
                        rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("genre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void recommendBooks() {
        System.out.print("Enter preferred genre: ");
        String genre = LibraryManagementSystem.scanner.nextLine();

        try (PreparedStatement stmt = Database.getConnection().prepareStatement("SELECT * FROM books WHERE genre = ?")) {
            stmt.setString(1, genre);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Title: %s, Author: %s%n", rs.getString("title"), rs.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
