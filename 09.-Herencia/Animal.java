

/*
vamos a crear un programa para guardar los datos de animales domesticos
*/ 

public class Animal{

    /*
    Encapsulamiento:

    Es poder restringir el acceso a los tipos de dato
    Vamos a poder agrupar en una clase el acceso a los diferentes
    metodos, atributos u objetos de clase, para
    que no puedan ser modificados desde otro lugar
    
    */

    private String nombre, raza, tipo_alimento;
    private int edad;
    //private boolean sexo = false;


    /*
    Cuando estamos aplicando el escapsulamiento se debe de agregar los metodos
    constructores

    El constructor nos sirve para poder declarar la existencia de una clase
    para poder iniciliazar las variables de la clase
    para poder hacer las instancias de la clase
    */ 

    public Animal(){
        //esto es un constructor
        /*
        Podemos inicializar las variables
        Podemos aplicar la sobrecarga        
        */ 
    }

    public Animal(String nombre, String raza, String tipo_alimento, int edad){
        //podemos realizar operaciones con cada uno de los parametros
        /*
        Se estan obteniendo el paso de parametros de cada una de las variables para conocer
        su valor */
        this.nombre = nombre;
        this.raza = raza;
        this.tipo_alimento = tipo_alimento;
        this.edad = edad;
        //this.sexo = sexo;
    }

    /*
    cuando los atributos son de tipo private:

    debemos de acceder a los datos a traves del uso de los metodos
    get  obtener   -> recibir
    set  asignar   -> enviar
    */ 
    //recibir
    public String getNombre(){
        return nombre;
    }

    //enviar
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //recibir
    public String getRaza(){
        return raza;
    }

    //enviar
    public void setRaza(String raza){
        this.raza = raza;
    }
    //recibir
    public String getTipo_alimento(){
        return tipo_alimento;
    }

    //enviar
    public void setTipo_alimento(String tipo_alimento){
        this.tipo_alimento = tipo_alimento;
    }

    //recibir
    public int getEdad(){
        return edad;
    }

    //enviar
    public void setEdad(int edad){
        this.edad = edad;
    }
    //recibir
   // public boolean getSexo(){
    //    return sexo;
    //}

    //enviar
    //public void setSexo(boolean sexo){
    //    this.sexo = sexo;
    //}


}