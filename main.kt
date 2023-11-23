import java.util.*
import kotlin.concurrent.schedule
import  clases.*

fun mario(){
    var mario = Mario()
    // Mario va a chocar contra un objeto que se llama "Pipe"
    mario.collision("Pipe")
    // Mario va a chocar contra un objeto que se llama "Goomba"
    // El objeto Goomba es para que pierda una vida
    mario.collision("Goomba")
    println("Te quedan ${mario.getLives()}")

    // GET = LEER/ SET = ESCRIBIR


    // EN UN FOR DE 5 VECES VA A ESTAR MARIO CHOCANDO CONTRA EL GOOMBA
    for (i in 1..5){
        if(mario.isAlive){
            mario.collision("Goomba")
            println("Te quedan ${mario.getLives()}")
        }
    }
}



fun main(){
    //telefono()
    //vehiculo()
    //calculadora()
    mario()

    var enemy = Goomba(name:"Un enemigo", strength:2)
    //persona()
}