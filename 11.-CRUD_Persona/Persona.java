


public class Persona{

    //variables
    private int id;
    private String nombre;
    private int edad;
    //appat
    //apmat
    //dir
    //colonia

    //constructor
    public Persona(){

    }

    //sobrecarga al constructor
    public Persona(int id, String nombre, int edad){
        //para inicializar las variables ocupo this
        this.id = id;   //aqui le estoy diciendo que la variable id le asigno el valor del parametro id
        this.nombre = nombre;
        this.edad = edad;
    }

    //getters y setters
    //recibe
    public int getId(){
        return id;
    }
    //enviar
    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    //enviar
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return edad;
    }
    //enviar
    public void setEdad(int edad){
        this.edad = edad;
    }


}