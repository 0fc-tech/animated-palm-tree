package com.example.mod2boucles

import kotlin.random.Random

fun main2() {
    val listClient = listOf("John Doe", "Peter Parker",
        "Harry Potter", "Tony Stark")
    for(client in listClient){
        println("Bienvenu $client,\n Notre solution" +
                " de paiement est conçue pour vous")
    }
}

fun main(){
    val secretNumber = Random.nextInt(1, 11)
    var guess: Int
    var attempts = 0

    println("Devinez le nombre entre 1 et 10!")

    while (true) {
        print("Entrez votre nombre: ")
        guess = readLine()!!.toInt()
        attempts++

        if (guess == secretNumber) {
            println("Bravo! vous avez trouvé $secretNumber en $attempts tentatives.")
            break
        } else {
            println("Essayez encore.")
        }
    }
}
