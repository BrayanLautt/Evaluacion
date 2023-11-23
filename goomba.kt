package clases

class Goomba(name:String, strength : Int): Enemy (name, strength){
    init{
        println("Iniciando sub clase $name")
    }

}