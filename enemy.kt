// ESTA ES LA SUPER CLASE

package clases

class Enemy(val name: String, val strength: Int) {
    protected var direction: String = "LEFT" // La dirección hacia donde camina un enemigo

    // Cambiar el sentido de movimiento al contrario
    protected fun changeDirection(){
        direction= if (direction=="RIGHT") "LEFT" else "RIGHT"
        println("$name va en direccion $direction")
    }

    // Indicamos al jugador que nuestro enemigo ha muerto
    protected fun die(){
        println("$name ha muerto")
    }

    // Decide que acción ejecutar dependiendo del objeto con que se colisiona
    fun collision(collider: String){
        when(collider){
            "Weapon" -> die()
            "Enemy" -> changeDirection()
        }
    }
}

//    equals(Other:Any?)
