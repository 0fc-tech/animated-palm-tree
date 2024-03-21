package com.example.mod2variables
fun main() {
    val idLastProduct = 120L
    //Impossible de redéfinir une val
    //idLastProduct = 0

    val orderName :String? = null
    //String interpolcation avec une valeur nulle
    val emailObject = "This order is named $orderName"

    var subtotal :Int? = null
    //On utilise ?. pour éxécuter une méthode sur une instance nullable
    val totalPlusTaxes = subtotal?.times(1.2)

    var qtyInCart : Int? = null
    //On utilise ?: lorsqu'on veut retourner une valeur quand
    // ce qu'il y a gauche de l'opérateur est null
    var qtyBilled = qtyInCart?.plus(8) ?: 0
    //Ici, si qtyInCart est null, qtyBilled aura pour valeur 0
}
