import javax.swing.*;
import java.util.ArrayList;// Sirve para crear arreglos que se pueden modificar facilmente 

public class Menu_Estudiantes_Profesores{
	
	/* 
		Se declaran dos arreglos, uno para almacenar alumnos y otro para los profesores 
	*/
	static ArrayList<Estudiante> EST = new ArrayList<Estudiante>();
	static ArrayList<Profesor> PRO = new ArrayList<Profesor>();
	static int contador_estudiantes = 0; //Cuantos estudiantes existen al momento
	static int contador_profesores = 0;  //Cuantos profesores existen al momento
	static float suma_promedios = 0;     //Suma de los promedios de todos los alumnos que existen al momento
	/* 
		Todas las varibles aqui se declaran static para que puedan actuar de forma "global"
		dentro de la clase principal y puedan ser modificadas por las funciones dentro
		de esta
	*/
	
	public static void main(String args[]){
		String input;
		do{
			input = Menu();
			/*
				Se usa try{ } para poder ejecutar algo primeramente y 
				catch { } para poder atrapar las exceptiones que
				puede lanzar una funcion en caso de que algo no salga
				bien sin tener que salir del programa.
			*/
			try{
				//Se usa un switch para seleccionar las opciones
				//Cada accion esta guardada en una funcion diferente
				switch(input){
					case "Agregar estudiante": Agregar_Estudiante(); break;
					case "Agregar profesor": Agregar_Profesor(); break;
					case "Revisar estudiante": Revisar_Estudiante(); break;
					case "Revisar profesor": Revisar_Profesor(); break;
					case "Eliminar estudiante": Eliminar_Estudiante(); break;
					case "Eliminar profesor": Eliminar_Profesor(); break;
					case "Revisar todos los estudiantes": 	if(contador_estudiantes != 0) Revisar_Estudiante_ALL();
															else JOptionPane.showMessageDialog(null, "NO HAY ALUMNOS REGISTRADOS", "ERROR", 0);
															break;
					case "Revisar todos los profesores": 	if(contador_profesores != 0) Revisar_Profesor_ALL();
															else JOptionPane.showMessageDialog(null, "NO HAY PROFESORES REGISTRADOS", "ERROR", 0);
															break;
					case "Promedio grupal": if(contador_estudiantes == 0) JOptionPane.showMessageDialog(null, "NO HAY ALUMNOS REGISTRADOS", "ERROR", 0);
											else Promedios();
											break;
					default: break;
				}
			} catch (NullPointerException e){ /*
												Esta excepcion se atrapa cuando el usuario presiona el boton de
												Cancel mientras esta en el menu de inicio. Aunque no se coloque
												esto aqui se sale del programa pero es para que no se impriman
												errores de ejecucion en la linea de comando
											  */
				input = "Salir";
			}
		}while(input != "Salir");
		//Solo se sale del programa si la opcion es Salir o el clic en Cancelar
	}
	
	/*
		Funcion que muestra el menu y regresa la opcion seleccionada
	*/
	public static String Menu(){
		String Opciones[] = { 	"Agregar estudiante",
								"Agregar profesor", 
								"Revisar estudiante",
								"Revisar profesor",
								"Eliminar estudiante",
								"Eliminar profesor",
								"Revisar todos los estudiantes",
								"Revisar todos los profesores",
								"Promedio grupal",
								"Salir" };
								
		String input;
		input = (String) JOptionPane.showInputDialog(	null, //Objeto componente padre
														"MENU DE REGISTRO\nSelecciona una opcion.", //Mensaje principal
														"REGISTRO DE ESTUDIANTES/PROFESORES", //Titulo de la ventana
														3, //Tipo de mensaje
														null, //Icono que se mostrara, como no tenemos, se usa null.
														Opciones, //Arreglo de opciones que se usaran, en vez de pedirle una entrada
																  //al usuario, solo te permite seleccionar de las opciones ya
																  //establecidas en un arreglo.
														Opciones[0]); //Opcion inicial al abrir la ventana.
		return input; //Regresa el valor para que en el metodo principal se determine lo que se quiere hacer
	}
	
	/*
		Funcion que agrega a un estudiante
	*/
	public static void Agregar_Estudiante(){
		Estudiante tmp = new Estudiante(); //Se declara un objeto temporal para la captura de datos
		//Se capturan todos los datos por medio de ventanas de dialogo.
		tmp.setNombre(JOptionPane.showInputDialog(null, "NOMBRE DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
		tmp.setCorreo(JOptionPane.showInputDialog(null, "CORREO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
		tmp.setDireccion(JOptionPane.showInputDialog(null, "DIRECCION DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
		tmp.setGenero(JOptionPane.showInputDialog(null, "GENERO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
		/*
			Se trata de atrapar una excepcion en caso de que el usuario introduzca un dato no numerico o no entero
		*/
		try{
			tmp.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "EDAD DEL ALUMNO", "CAPTURA DE ALUMNOS", 3)));
		} catch (NumberFormatException e){
			tmp.setEdad(19); // Se pone una edad especifica en caso de que ocurra.
		}
		tmp.setMatricula(JOptionPane.showInputDialog(null, "MATRICULA DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
		/*
			Se trata de atrapar una excepcion en caso de que el usuario introduzca un dato no numerico o no entero
		*/
		try{
			tmp.setPromedio(Float.parseFloat(JOptionPane.showInputDialog(null, "PROMEDIO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3)));
		} catch (NumberFormatException e){
			tmp.setPromedio(0); // Se pone una calificacion de 0 en caso de ocurrir
		}		
		suma_promedios += tmp.getPromedio(); //Se suman los promedios en la variable estatica declarada en el inicio
		EST.add(tmp); //Se agrega el objeto al arreglo de estudiantes declarados al inicio de la clase principal
		JOptionPane.showMessageDialog(null, "ALUMNO REGISTRADO", "CAPTURA DE ALUMNOS", 1);
		contador_estudiantes++; //Se le agrega un elemento al contador de estudiantes
	}
	
	/*
		Funcion que agrega a un profesor, similar a la anterior
	*/
	public static void Agregar_Profesor()
	{
		Profesor tmp = new Profesor(); //Se declara un objeto temporal para la captura de datos
		//Se capturan todos los datos por medio de ventanas de dialogo.
		tmp.setNombre(JOptionPane.showInputDialog(null, "NOMBRE DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
		tmp.setCorreo(JOptionPane.showInputDialog(null, "CORREO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
		tmp.setDireccion(JOptionPane.showInputDialog(null, "DIRECCION DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
		tmp.setGenero(JOptionPane.showInputDialog(null, "GENERO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
		/*
			Se trata de atrapar una excepcion en caso de que el usuario introduzca un dato no numerico o no entero
		*/
		try{
			tmp.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "EDAD DEL PROFESOR", "CAPTURA DE PROFESORES", 3)));
		} catch (NumberFormatException e){
			tmp.setEdad(19);
		}
		tmp.setGrado(JOptionPane.showInputDialog(null, "GRADO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
		/*
			Se trata de atrapar una excepcion en caso de que el usuario introduzca un dato no numerico o no entero
		*/
		try{
			tmp.setNum_Empleado(Integer.parseInt(JOptionPane.showInputDialog(null, "NUMERO DE EMPLEADO", "CAPTURA DE PROFESORES", 3)));
		} catch (NumberFormatException e){
			tmp.setNum_Empleado(0);
		}		
		PRO.add(tmp); //Se agrega el objeto al arreglo de estudiantes declarados al inicio de la clase principal
		JOptionPane.showMessageDialog(null, "PROFESOR REGISTRADO", "CAPTURA DE PROFESORES", 1);
		contador_profesores++; //Se le agrega un elemento al contador de profesores
	}
	
	/*
		Funcion que permite revisar los datos de un estudiante
	*/
	public static void Revisar_Estudiante()
	{
		int i; //Se declara externa para que pueda ser utilizada despues en caso de que si se localize un alumno
		boolean respuesta = false; //Se declara false y se mantiene asi a menos de que si se localize un alumno
		Estudiante tmp; //Objeto temporal
		//La funcion pide la matricula
		//Se declara una mat_tmp para comprobar la existencia de un usuario a traves de la matricula
		String mat_tmp = JOptionPane.showInputDialog(null, "INTRODUCE LA MATRICULA DEL ALUMNO", "ALUMNOS", 3);
		for(i = 0; i < contador_estudiantes; i++){
			//Se recorre a traves de todos los estudiantes hasta que se encuentre el indicado.
			tmp = EST.get(i);
			if(mat_tmp.equals(tmp.getMatricula())){
				/*
					Si logra encontrar una igual, el valor de respuesta ahora es
					verdad y se sale del ciclo, en caso de que no, se mantiene en
					falso y el programa le avisa al usuario de que no existe tal
					alumno.
					
					Se uso el metodo equals(String) de la clase de String para
					asegurar de mejor manera de que las cadenas sean identicas o no,
					porque capturar datos de cierta forma puede causar pequeñas
					diferencias aunque las cadenas a simple vista se vean exactamente
					iguales. Regresa true si son iguales y false si no lo son.
				*/
				respuesta = true;
				break;
			}
		}
		if(respuesta == true){ //Si se encontro, se imprimen los resultados
			tmp = EST.get(i); // Se almacenan los datos en el objeto temporal para facilitar la impresion
			JOptionPane.showMessageDialog(null, "ALUMNO: " + (i+1) 
			+ "\nNOMBRE: " + tmp
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nMATRICULA: " + tmp.getMatricula() 
			+ "\nPROMEDIO: " + tmp.getPromedio(), "ALUMNO", 1);
		}
		else{
			//Si no se encuentra, se le notifica al usuario.
			JOptionPane.showMessageDialog(null, "ALUMNO NO LOCALIZADO", "ALUMNOS", 1);
		}
	}
	
	/*
		Funcion que permite revisar los datos de un profesor, similar a la anterior.
	*/
	public static void Revisar_Profesor()
	{
		int i; //Se declara externa para que pueda ser utilizada despues en caso de que si se localize un profesor
		boolean respuesta = false; //Se declara false y se mantiene asi a menos de que si se localize un profesor
		Profesor tmp; //Objeto temporal
		//Se declara num_tmp para comprobar la existencia del profesor a traves del numero de empleado
		int num_tmp;
		/*
			Se trata de atrapar una excepcion en caso de que el usuario introduzca un dato no numerico o no entero
		*/
		try{
			num_tmp = Integer.parseInt(JOptionPane.showInputDialog(null, "INTRODUCE EL NUMERO DE EMPLEADO", "PROFESORES", 3));
		} catch (NumberFormatException e){
			num_tmp = -1;
		}
		for(i = 0; i < contador_profesores; i++){
			tmp = PRO.get(i);
			if(num_tmp == tmp.getNum_Empleado()){
				respuesta = true;
				break;
			}
		}
		if(respuesta == true){
			tmp = PRO.get(i);
			JOptionPane.showMessageDialog(null, "PROFESOR: " + (i+1) 
			+ "\nNOMBRE: " + tmp 
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nNUMERO DE EMPLEADO: " + tmp.getNum_Empleado() 
			+ "\nGRADO: " + tmp.getGrado(), "PROFESOR", 1);
		}
		else{
			JOptionPane.showMessageDialog(null, "PROFESOR NO LOCALIZADO", "PROFESORES", 1);
		}
	}
	
	/*
		Funcion que permite revisar los datos de TODOS los estudiantes
	*/
	public static void Revisar_Estudiante_ALL(){
		Estudiante tmp;
		//Se usa el contador de estudiantes previamente declarado para poder imprimirlos a todos.
		for(int i = 0; i < contador_estudiantes; i++){
			tmp = EST.get(i); // Se almacenan los datos en el objeto temporal para facilitar la impresion
			JOptionPane.showMessageDialog(null, "ALUMNO: " + (i+1) 
			+ "\nNOMBRE: " + tmp 
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nMATRICULA: " + tmp.getMatricula() 
			+ "\nPROMEDIO: " + tmp.getPromedio(), "ALUMNO", 1);
		}
	}
	
	/*
		Funcion que permite revisar los datos de TODOS los profesores
	*/
	public static void Revisar_Profesor_ALL(){
		Profesor tmp;
		//Se usa el contador de profesores previamente declarado para poder imprimirlos a todos.
		for(int i = 0; i < contador_profesores; i++){
			tmp = PRO.get(i); // Se almacenan los datos en el objeto temporal para facilitar la impresion
			JOptionPane.showMessageDialog(null, "PROFESOR: " + (i+1) 
			+ "\nNOMBRE: " + tmp 
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nNUMERO DE EMPLEADO: " + tmp.getNum_Empleado() 
			+ "\nGRADO: " + tmp.getGrado(), "PROFESOR", 1);
		}
	}
	
	/*
		Funcion que permite eliminar a un estudiante
		Funciona de la misma manera que la de localizar a un estudiante a traves de la matricula
		pero el objetivo es diferente.
	*/
	public static void Eliminar_Estudiante()
	{
		int i;
		boolean respuesta = false;
		Estudiante tmp;
		String mat_tmp = JOptionPane.showInputDialog(null, "INTRODUCE LA MATRICULA DEL ALUMNO", "ELIMINAR ALUMNO", 3);
		for(i = 0; i < contador_estudiantes; i++){
			tmp = EST.get(i);
			if(mat_tmp.equals(tmp.getMatricula())){
				respuesta = true;
				break;
			}
		}
		if(respuesta == true){
			tmp = EST.get(i);
			JOptionPane.showMessageDialog(null, "ALUMNO: " + (i+1) 
			+ "\nNOMBRE: " + tmp
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nMATRICULA: " + tmp.getMatricula() 
			+ "\nPROMEDIO: " + tmp.getPromedio(), "ELIMINAR ALUMNO", 1);
			
			EST.remove(i); // Metodo remove de ArrayList que permite eliminar un elemento del arreglo en tal posicion que se encuentra.
			suma_promedios -= tmp.getPromedio(); //Se resta el promedio del estudiante a la suma total
			JOptionPane.showMessageDialog(null, "ALUMNO ELIMINADO", "ELIMINAR ALUMNO", 3);
			contador_estudiantes--; //Se le resta un elemento al contador de estudiantes
		}
		else{
			JOptionPane.showMessageDialog(null, "ALUMNO NO LOCALIZADO", "ELIMINAR ALUMNO", 1);
		}
	}
	
	/*
		Funcion que permite eliminar a un estudiante, similar a la anterior 
		y a la de localizar a un profesor.
	*/
	public static void Eliminar_Profesor()
	{
		int i;
		boolean respuesta = false;
		Profesor tmp;
		int num_tmp;
		try{
			num_tmp = Integer.parseInt(JOptionPane.showInputDialog(null, "INTRODUCE EL NUMERO DE EMPLEADO", "ELIMINAR PROFESOR", 3));
		} catch (NumberFormatException e){
			num_tmp = -1;
		}
		for(i = 0; i < contador_profesores; i++){
			tmp = PRO.get(i);
			if(num_tmp == tmp.getNum_Empleado()){
				respuesta = true;
				break;
			}
		}
		if(respuesta == true){
			tmp = PRO.get(i);
			JOptionPane.showMessageDialog(null, "PROFESOR: " + (i+1) 
			+ "\nNOMBRE: " + tmp 
			+ "\nCORREO: " + tmp.getCorreo() 
			+ "\nDIRECCION: " + tmp.getDireccion() 
			+ "\nGENERO: " + tmp.getGenero() 
			+ "\nEDAD: " + tmp.getEdad() 
			+ "\n\nNUMERO DE EMPLEADO: " + tmp.getNum_Empleado() 
			+ "\nGRADO: " + tmp.getGrado(), "ELIMINAR PROFESOR", 1);
			
			PRO.remove(i); //Se elimina del arreglo
			JOptionPane.showMessageDialog(null, "PROFESOR ELIMINADO", "ELIMINAR PROFESOR", 3);
			contador_profesores--; //Se le descuenta uno al contador de profesores
		}
		else{
			JOptionPane.showMessageDialog(null, "PROFESOR NO LOCALIZADO", "ELIMINAR PROFESOR", 1);
		}
	}
	
	public static void Promedios()
	{
		//Funcion que imprime el promedio general del grupo, dividiendo la suma de todos los promedios por el contador de estudiantes.
		JOptionPane.showMessageDialog(null, "PROMEDIO GRUPAL: " + (float)(suma_promedios/contador_estudiantes), "PROMEDIO", 1);
	}
}


/*
	Clase de persona, que contiene las caracteristicas en comun entre un estudiante y un profesor
*/
class Persona{
	String Nombre, Correo, Direccion, Genero; int Edad;
	
	public void setNombre(String Nombre){ 
		this.Nombre = Nombre; 
	}
	public void setCorreo(String Correo){
		this.Correo = Correo; 
	}
	public void setDireccion(String Direccion){
		this.Direccion = Direccion; 
	}
	public void setGenero(String Genero){
		this.Genero = Genero; 
	}
	public void setEdad(int Edad){
		this.Edad = Edad; 
	}
	
	public String toString(){
		return Nombre; 
	}
	public String getCorreo(){
		return Correo; 
	}
	public String getDireccion(){
		return Direccion; 
	}
	public String getGenero(){
		return Genero;
	}
	public int getEdad(){
		return Edad; 
	}
}

/*
	Clase de estudiante, hereda todas las variables y metodos de persona aparte de incluir sus propios
*/
class Estudiante extends Persona{
	String Matricula; float Promedio;
	
	public void setMatricula(String Matricula){
		this.Matricula = Matricula; 
	}
	public void setPromedio(float Promedio){
		this.Promedio = Promedio;
	}
	
	public String getMatricula(){
		return Matricula;
	}
	public float getPromedio(){
		return Promedio;
	}
}

/*
	Clase de profesor, hereda todas las variables y metodos de persona aparte de incluir sus propios
*/
class Profesor extends Persona{
	int Num_Empleado; String Grado;
	
	public void setNum_Empleado(int Numero){
		Num_Empleado = Numero;
	}
	public void setGrado(String Grado){
		this.Grado = Grado;
	}
	
	public int getNum_Empleado(){
		return Num_Empleado;
	}
	public String getGrado(){
		return Grado;
	}
}
