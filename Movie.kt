package Clases

/*Data class es una clase que tiene como unico objetivo es cargar información en una clase a través de su constructor
sin poder definir métodos para modificar o eliminar sus datos*/

data class Movie(val name: String, val gender: String, val duration: Double) {
    var createdAt = ""
}