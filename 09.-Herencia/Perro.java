/*
Para poder aplicar la herencia de una clase, se utiliza la palabra reservada

extends

Eso significa que la clase va a heredar de una clase padre

Animal es la clase padre
Perro es la clase hija

*/ 

public class Perro extends Animal{
    /*
    Aqui deberia de colocar cada atributo
    nombre, raza, edad, tipo_alimento, sexo
    */

    String ladrido;

    public Perro(){
        //constructor de la clase
    }

    //sobrecarga para obtener y enviar el ladrido
    public Perro(String nombre, String raza, String tipo_alimento, 
    int edad, String ladrido){
        //para poder obtener los atributos por herencia
        //se debe de colocar super
        super(nombre, raza, tipo_alimento, edad);
        this.ladrido = ladrido;

    }
    public String getLadrido(){
        return ladrido;
    }

    //enviar
    public void setLadrido(String ladrido){
        this.ladrido = ladrido;
    }

    //metodo para mostrar la informacion del perro
    public void mostrarPerro(){
        System.out.println("El nombre del perro es: " + getNombre() +"\n"
                            + "Su raza es: " + getRaza() +"\n"
                            + "Se alimenta de: " + getTipo_alimento() +"\n"
                            + "Tiene la edad de: " + getEdad() +"\n"
                            //+ "Su sexo es: " + getSexo() +"\n"
                            + "Su ladrido es: " + ladrido  +"\n");
    }
}