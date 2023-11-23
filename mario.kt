
import java.util.*
import kotlin.concurrent.schedule
import kotlin.time.measureTimedValue

class Mario(var vidas: Int =3) { // Vamos a dejar setear el número de vidas al iniciar el objeto Mario

    init {
        println("It´s a me! Mario!") // Vamos a hacer que Mario se presente al construirlo
    }


    private var state = "small" // Uno empieza el juego con 3 vidas
        set(value){
            val before = field
            field =  value
            println("Tu estado ahora es $field")
            if(value=="Star"){
                Timer("SettingUp",false).schedule(10000){
                    field=before
                    println("Tu estado ahora es $field")
                }
            }
            field=value
        }

    // NO SE DEBEN COLOCAR DOS SET'S JUNTOS

    private var lives = 3

        //Timer("SettingUP", false).schedule(10000){}

        set(value){
            if(field == 1){
                field = 0
                gameOver()
            } else if (field == 0){
                println("Necesitas volver a jugar")
            } else {
                field = value // Podemos asignar el valor correctamente
            }
        }

    // Resta una vida al jugador
    private fun die(){
        lives--
        println("Has perdido una vida!")
    }

    // El modificador public es redundante
    // En función del objeto colisionante, se ejecutará un evento
    public fun collision(collisionObj: String){

        when(collisionObj){
            // YA NO NECESITAMOS FUNCION DIE
            // Porque lo hace directamente con lives--
            "Goomba"-> lives--
            "Super Mushroom"->state="Super Mario"
            "Super flower"->state = "Fire Mario"

            "Star" -> state="Star"


            else -> println("Objeto desconocido ¡No pasa nada!")
        }
    }


    // Este GET de las variables privadas va a verificar y retorna cuantas vidas tengo
    fun getLives():String{
        return ("$lives vidas")
    }

   // Función GameOver en donde muestra que el juego ha terminado.
    private fun gameOver(){
        println("¡JUEGO TERMINADO!")
    }

    // GET = LEER
    // SET = ESCRIBIR


    // ESTADO DE MARIO
    fun statusMario():Boolean{
        // Si vida es mayor que uno retorna verdadero
        if (lives > 1){
            return true
        }
        // Caso contrario, retorna Falso
        else {
            return false
        }
    }

    // Se mantiene en estado vivo mientras sus vidas sean mayor o igual a uno
    // En caso contrario va a la función GameOver
    val isAlive: Boolean
        // FUNCION GET (LECTURA)  NOS PERMITE SABER SI SEGUIMOS VIVOS
        get() {
            return lives >=1
        }

}