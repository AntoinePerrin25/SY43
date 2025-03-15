package com.example.td1

data class Book(val title: String, val author: String, val description: String, val id: Int, var available: Boolean = false) {
    override fun toString(): String {
        return "Titre : $title\n" +
                "Auteur : $author\n" +
                "Description : $description\n" +
                "Available : ${if (available) "Oui" else "Non"}\n"
    }

    fun toString(preString: String): String {
        return "Titre : $title\n${preString}" +
                "Auteur : $author\n${preString}" +
                "Description : $description\n${preString}" +
                "Available : ${if (available) "Oui" else "Non"}\n"
    }

    fun toString(maxLenght: Int, preString: String): String
    {
        if (maxLenght <= 0) {
            return "Titre : $title\n" +
                    "${preString}Auteur : $author\n" +
                    "${preString}Description : $description\n" +
                    "${preString}Available : ${if (available) "Oui" else "Non"}\n"
        } else {
            // We need to cut the description in multiple lines
            var returnstring: String = "Titre : $title\n${preString}" +
                    "Auteur : $author\n${preString}" +
                    "Description : "

            var vardescription = description
            while (vardescription.length > maxLenght) {
                returnstring += "${vardescription.substring(0, maxLenght)}\n${preString}"
                vardescription = vardescription.substring(maxLenght)
            }
            returnstring += "$vardescription\n${preString}" +
                    "Available : ${if (available) "Oui" else "Non"}\n"
            return returnstring
        }
    }
}
