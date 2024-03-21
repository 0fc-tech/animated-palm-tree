package com.example.mod2conditions

fun main() {
    val customerLivingFrance = true
    val customerLivingNl = false
    val shippingCost = if (customerLivingFrance)
        5
    else if (customerLivingNl)
        8
    else
        78
}

fun main2() {
    val idCategorie = 9832
    val tabCat = intArrayOf(1002,1005,1006,1009)
    val categorieGenerale = when (idCategorie) {
        in 1..1000 -> "Alimentaire"
        in 1001..4500 -> "Culture"
        in  intArrayOf(1002,1005,1006,1009) -> println("Oui")
        else -> "Santé"
    }
}
