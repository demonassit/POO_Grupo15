


import java.util.*;
//import AccionesPersona;






public class manipularPrograma{

    public void menu(){
        Scanner entrada = new Scanner(System.in);

        //instancias de las clases de Persona y de AccionesPersona
        AccionesPersona control = new AccionesPersona();

        System.out.println("Bienvenido al programa de registro de truenalos");
        System.out.println("Elije la opcion deseada:");
        System.out.println("1.- Mostrar Todas las Personas");
        System.out.println("2.- Registrar nueva victima");
        System.out.println("3.- Editar sus datos");
        System.out.println("4.- Borrar a esa Persona");
        System.out.println("5.- Salir");

        int opcion = Integer.parseInt(entrada.nextLine());

        switch (opcion) {
            case 1:
                //mostrar a todas las personas
                //instancia del array
                ArrayList<Persona> listadepersonas = control.mostrarPersonas();

                //falta imprimir esa lista
                //recorrer la lista de personas
                for(Persona objeto : listadepersonas){
                    System.out.println("El id es : " + objeto.getId() 
                                        + "\n" + "El nombre es: " + objeto.getNombre()
                                        + "\n" + "Su edad es: " + objeto.getEdad() );
                }
                menu();
                
                break;
            case 2:
                //debemos agregar a la persona
                System.out.println("Ingrese el ID de la persona: ");
                int idpersona = Integer.parseInt(entrada.nextLine());
                System.out.println("Ingrese el nombre de la persona: ");
                String nombrepersona = entrada.nextLine();
                System.out.println("Ingrese la edad de la persona: ");
                int edadpersona = Integer.parseInt(entrada.nextLine());

                /*
                ya que obtube los datos para agregarlos a la lista de personas
                debo de crear el objeto que pase esos parametros
                */ 

                Persona personaNueva = new Persona(idpersona, nombrepersona, edadpersona);

                control.agregarPersona(personaNueva);
                menu();
                break;
            
            case 3:
                //primero debo de buscar a la persona que quiero editar
                System.out.println("Digite el ID de la Persona que desea buscar");
                idpersona = Integer.parseInt(entrada.nextLine());

                //mando a llamar a mi objeto de persona para buscarla

                Persona personaBuscar = control.buscarPersona(idpersona);

                //primero visualizamos los datos de la persona
                System.out.println("La informacion de la persona es: \n" 
                                    + "ID: " + personaBuscar.getId() + "\n"
                                    + "Nombre: " + personaBuscar.getNombre() + "\n"
                                    + "Edad: " + personaBuscar.getEdad()+ "\n");
                
                //que datos son los que e pueden cambiar
                System.out.println("Ingresa el nuevo nombre");
                String nuevonombre = entrada.nextLine();
                System.out.println("Ingresa la nueva edad");
                int nuevaedad = Integer.parseInt(entrada.nextLine());

                //como ya tengo los nuevos datos debo de enviarlos al objeto de la persona
                personaBuscar.setNombre(nuevonombre);
                personaBuscar.setEdad(nuevaedad);

                //ahora si actualizo a mi objeto de la persona
                control.actualizarPersona(personaBuscar);
                menu();
                break;

            case 4:
                System.out.println("Digite el ID de la persona que desea eliminar:");
                idpersona = Integer.parseInt(entrada.nextLine());

                //creo mi objeto de la persona que voy a eliminar
                Persona personaEliminar = control.buscarPersona(idpersona);

                control.eliminarPersona(personaEliminar);

                System.out.println("El registro se a borrado del sistema");
                menu();
                break;
        
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}