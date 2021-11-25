/*

esta clase es el controlador (son las acciones de la persona, para poder
manipular los datos) 
*/

import java.util.ArrayList;
import Persona;


// vamos a hacer el CRUD de personas
//  Altas, Bajas, Modificaciones Consultas de un objeto
//C -> consult   R ->register     U-> update  D -> Delete

public class AccionesPersona{

    /*
    voy a necesitar hacer una instancia de persona para poder
    manipular los datos y guardarlos dentro de un objeto que pueda
    soportar diferentes tipos de dato, para ello ocupo 
    ArrayList
    */

    //declaro mi obj de arraylist
    public ArrayList<Persona> listaPersona = new ArrayList<Persona>(); 
    //tipo de acceso   clase <obj>  objeto de objetos

    //metodo para agregar a una persona
    public void agregarPersona(Persona p){
        //mando a llamar a mi objeto lista de personas e invoco el metodo agregar
        listaPersona.add(p);
    }

    //buscar a una persona por id
    public Persona buscarPersona(int id){
        //necesito una instancia de Persona para poder buscarla
        Persona encontrada = new Persona();

        //necesito recorrer todo el arreglo de personas hasta encontrar el id que quiero
        //id = parametro

        for(Persona p : listaPersona){ 
            //aqui es donde tengo mi condicion id = parametro
            if(id == p.getId()){
                //le asigno a mi objeto persona(encontrada) los valores
                encontrada = p;
            }else{
                System.out.println("No existe ese registro");
            }
        }

        //cuando es un metodo que no es vacio se debe de retornar un valor
        return encontrada;

    }

    //actualizar los datos de la persona
    public void actualizarPersona(Persona actualizada){ //este es el boton
        //primero debo de buscar a una persona, obtener sus datos y elegir cual voy a cambiar
        //creo a mi instancia de persona
        Persona actualizar = buscarPersona(actualizada.getId());

        //cambio los datos
        listaPersona.remove(actualizar);

        //guardo
        listaPersona.add(actualizar);
    }

    //eliminar a una persona
    public void eliminarPersona(Persona eliminar){
        listaPersona.remove(eliminar);
    }

    //mostrar a todas las personas
    public ArrayList<Persona> mostrarPersonas(){
        return listaPersona;
    }
}