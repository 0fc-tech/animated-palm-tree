package com.example.mod2structureclasse

data class Travail(
    val intitulePoste :String,
    var salaireAnnuel : Int,
    var isCadre: Boolean,
    var ville: String?
)
fun main() {
    val developpeurNantais = Travail(
        "Développeur",
        34000,
        true,"Nantes")
    val designerTeleTravail = Travail(
        "Designer", 44000,
        true,null)
    val dirigeantESN = Travail("PDG",
        74000,
        true,"Paris")
    val developpeurAngevin = developpeurNantais.copy()
    println("Le développeur angevin : $developpeurAngevin")
    println("Le développeur angevin est-il le même que le nantais " +
            "${developpeurAngevin.equals(developpeurNantais)}")
}
class AppareilBluetooth(val macAdress:String){
    fun connecter(){}
}
