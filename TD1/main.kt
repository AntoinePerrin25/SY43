package com.example.td1

fun main() {
    val library = Library("My Library")
    var running = true
    var bookId = 0

    while (running) {
        println("\nMenu:")
        println("1. Add a book")
        println("2. Remove a book")
        println("3. Search for a book by title or author")
        println("4. Borrow a book")
        println("5. Return a book")
        println("6. Display the list of books")
        println("7. Exit the program")

        print("Enter your choice: ")
        when (readLine()) {
            "1" -> {
                print("Title: ")
                val title = readLine() ?: ""
                print("Author: ")
                val author = readLine() ?: ""
                print("Description: ")
                val description = readLine() ?: ""

                val book = Book(title, author, description, bookId++, true)
                library.addBook(book)
                println("Added book: $book")
            }

            "2" -> {
                println("Remove a book:")
                println("a) By ID")
                println("b) By title")
                println("c) By author")
                print("Enter your choice: ")

                when (readLine()?.lowercase()) {
                    "a" -> {
                        print("Enter ID: ")
                        val id = readLine()?.toIntOrNull() ?: -1
                        library.removeBook(id)
                        println("Removed book with ID: $id")
                    }
                    "b" -> {
                        print("Enter title: ")
                        val title = readLine() ?: ""
                        library.removeBook(title)
                        println("Removed book with title: $title")
                    }
                    "c" -> {
                        print("Enter author: ")
                        val author = readLine() ?: ""
                        val booksToRemove = library.searchBookByAuthor(author)
                        booksToRemove.forEach { library.removeBook(it.id) }
                        println("Removed ${booksToRemove.size} books by author: $author")
                    }
                    else -> println("Invalid option")
                }
            }

            "3" -> {
                println("Search for a book:")
                println("a) By title")
                println("b) By author")
                print("Enter your choice: ")

                when (readLine()?.lowercase()) {
                    "a" -> {
                        print("Enter title: ")
                        val title = readLine() ?: ""
                        val books = library.searchBookByTitle(title)
                        if (books.isNotEmpty()) {
                            println("Found books:")
                            books.forEach { println(it.toString("\t")) }
                        } else {
                            println("No books found with title: $title")
                        }
                    }
                    "b" -> {
                        print("Enter author: ")
                        val author = readLine() ?: ""
                        val books = library.searchBookByAuthor(author)
                        if (books.isNotEmpty()) {
                            println("Found books:")
                            books.forEach { println(it.toString("\t")) }
                        } else {
                            println("No books found by author: $author")
                        }
                    }
                    else -> println("Invalid option")
                }
            }

            "4" -> {
                println("Borrow a book:")
                println("a) By ID")
                println("b) By title")
                print("Enter your choice: ")

                when (readLine()?.lowercase()) {
                    "a" -> {
                        print("Enter ID: ")
                        val id = readLine()?.toIntOrNull() ?: -1
                        val borrowed = library.borrowBook(id)
                        if (borrowed != null) {
                            println("Successfully borrowed book with ID: $id")
                        } else {
                            println("Could not borrow book with ID: $id")
                        }
                    }
                    "b" -> {
                        print("Enter title: ")
                        val title = readLine() ?: ""
                        val borrowed = library.borrowBook(title)
                        if (borrowed != null) {
                            println("Successfully borrowed book: $title")
                        } else {
                            println("Could not borrow book: $title")
                        }
                    }
                    else -> println("Invalid option")
                }
            }

            "5" -> {
                println("Return a book:")
                println("a) By ID")
                println("b) By title")
                print("Enter your choice: ")

                when (readLine()?.lowercase()) {
                    "a" -> {
                        print("Enter ID: ")
                        val id = readLine()?.toIntOrNull() ?: -1
                        val returned = library.returnBook(id)
                        if (returned != null) {
                            println("Successfully returned book with ID: $id")
                        } else {
                            println("Could not return book with ID: $id")
                        }
                    }
                    "b" -> {
                        print("Enter title: ")
                        val title = readLine() ?: ""
                        val returned = library.returnBook(title)
                        if (returned != null) {
                            println("Successfully returned book: $title")
                        } else {
                            println("Could not return book: $title")
                        }
                    }
                    else -> println("Invalid option")
                }
            }

            "6" -> {
                println(library.toString())
                println(library.printBooks())
            }

            "7" -> {
                println("Exiting program...")
                running = false
            }

            else -> println("Invalid option. Please try again.")
        }
    }
}