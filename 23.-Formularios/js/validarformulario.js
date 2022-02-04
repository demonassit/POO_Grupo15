function validar(formulario){
    //quiero validar el tamaño del nombre
    if(formulario.nombre.value.length < 5){
        alert("Escriba por lo menos 6 caracteres en el campo nombre");
        //colocar cursor en el campo de error
        formulario.nombre.focus();
        return (false);
    }

    var checkOk = "QWERTYUIOPASDFGHJKLÑZXCVBNM"+"qwertyuiopasdfghjklñzxcvbnm";
    var checkStr = formulario.nombre.value;
    var allvalid = true;

    for(var i = 0; i < checkStr.length; i++ ){
        var ch = checkStr.charAt(i);
             
          for(var j = 0; j < checkOk.length; j++){
            if(ch == checkOk.charAt(j)) 
          
            break;
        }
            if(j == checkOk.length){
                allvalid = false;
                break;
            }
        
    }
    if(!allvalid){
        alert("Escribe solo letras en el campo Nombre");
        formulario.nombre.focus();
        return (false);
    }
}