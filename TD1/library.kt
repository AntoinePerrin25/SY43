package com.example.td1

class Library(var name: String)
{
    var books: List<Book> = listOf()

    override fun toString(): String {
        return "Library : $name\n" +
                "Books : ${books.size}\n"
    }

    fun printBooks(): String {
        var returnstring : String = ""
        for (book in books) {
            returnstring += "${book.toString("\t")}\n"
        }
        return returnstring
    }
    fun printBooks(maxLenght: Int): String {
        var returnstring : String = ""
        for (book in books) {
            returnstring += "${book.toString(maxLenght, "\t")}\n"
        }
        return returnstring
    }

    fun printAvailableBooks(): String {
        var returnstring : String = ""
        for (book in books) {
            if (book.available)
                returnstring += "${book.toString("\t")}\n"
        }
        return returnstring
    }
    fun printAvailableBooks(maxLenght: Int): String {
        var returnstring : String = ""
        for (book in books) {
            if (book.available)
                returnstring += "${book.toString(maxLenght, "\t")}\n"
        }
        return returnstring
    }


    fun getBook(title: String): Book? {
        for (book in books) {
            if (book.title == title) {
                return book
            }
        }
        return null
    }

    fun getBook(id: Int): Book? {
        for (book in books) {
            if (book.id == id) {
                return book
            }
        }
        return null
    }

    fun getBookID(title: String): Int {
        for (book in books) {
            if (book.title == title) {
                return book.id
            }
        }
        return -1
    }

    fun addBook(book: Book) {
        books += book
    }

    fun removeBook(id: Int) {
        if (id >= 0)
            books = books.filter { it.id != id }
    }
    fun removeBook(title: String) {
        books = books.filter { it.title != title }
    }


    //searchBookByTitle : Searches for books by title.
    fun searchBookByTitle(title: String): List<Book> {
        return books.filter { it.title == title }
    }
    //searchBookByAuthor : Searches for books by author.
    fun searchBookByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }

    //borrowBook : Allows borrowing a book if it is available.
    fun borrowBook(id: Int): Book?{
        val book = getBook(id)
        if (book != null && book.available) {
            println("Book : '$id' successfully borrowed")
            book.available = false
            return book
        }
        println("Book with ID '$id' could not be borrowed again")
        return null
    }

    fun borrowBook(title: String): Book?{
        val book = getBook(title)
        if (book != null && book.available) {
            println("Book : '$title' successfully borrowed")
            book.available = false
            return book
        }
        println("Book : '$title' could not be borrowed again")
        return null
    }

    // returnBook : Allows returning a borrowed book.
    fun returnBook(title: String): Book?{
        val book = getBook(title)
        if (book != null && !book.available) {
            book.available = true
            return book
        }
        return null
    }
    // returnBook : Allows returning a borrowed book.
    fun returnBook(id: Int): Book?{
        val book = getBook(id)
        if (book != null && !book.available) {
            book.available = true
            return book
        }
        return null
    }

}