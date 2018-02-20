import javax.swing.*; 

public class Alumnos_Maestros
{
	public static void main(String args[])
	{
		//Se captura la cantidad de alumnos que se quieren registrar por medio de una ventana de dialogo
		//Se usa Integer.parseInt para poder convertir un String a un numero entero.
		int Alumnos = Integer.parseInt(JOptionPane.showInputDialog(null, "INTRODUCE LA CANTIDAD DE ALUMNOS QUE VAS A CAPTURAR", "CAPTURA DE ALUMNOS", 3));
		//Se captura la cantidad de profesores que se quieren registrar por medio de una ventana de dialogo
		int Profesores = Integer.parseInt(JOptionPane.showInputDialog(null, "INTRODUCE LA CANTIDAD DE PROFESORES QUE VAS A CAPTURAR", "CAPTURA DE PROFESORES", 3));
		
		float promedios = 0; //Variable para calcular el promedio grupal de los alumnos
		
		//Declaracion de los arreglos de estudiantes y profesores.
		Estudiante Arr_Estudiantes[] = new Estudiante[Alumnos];
		Profesor Arr_Profesores[] = new Profesor[Profesores];
		
		//Ciclo que pide los datos del alumno
		for(int i = 0; i < Alumnos; i++)
		{
			//Creacion del objeto dentro de la posicion del arreglo
			Arr_Estudiantes[i] = new Estudiante();
			
			//Se reciben los datos de la persona que es el alumno
			//Nombre
			Arr_Estudiantes[i].setNombre(JOptionPane.showInputDialog(null, "NOMBRE DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
			
			//Correo
			Arr_Estudiantes[i].setCorreo(JOptionPane.showInputDialog(null, "CORREO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
			
			//Direccion 
			Arr_Estudiantes[i].setDireccion(JOptionPane.showInputDialog(null, "DIRECCION DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
			
			//Genero
			Arr_Estudiantes[i].setGenero(JOptionPane.showInputDialog(null, "GENERO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
			
			//Edad
			Arr_Estudiantes[i].setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "EDAD DEL ALUMNO", "CAPTURA DE ALUMNOS", 3)));
			
			//Datos significativos del alumno
			//Matricula
			Arr_Estudiantes[i].setMatricula(JOptionPane.showInputDialog(null, "MATRICULA DEL ALUMNO", "CAPTURA DE ALUMNOS", 3));
			//Promedio del alumno
			//Se usa Float.parseFloat para poder convertir un String a un valor Float
			Arr_Estudiantes[i].setPromedio(Float.parseFloat(JOptionPane.showInputDialog(null, "PROMEDIO POO DEL ALUMNO", "CAPTURA DE ALUMNOS", 3)));
			
			//Impresion de un mensaje que informa que se logro capturar al alumno.
			JOptionPane.showMessageDialog(null, "ALUMNO " + (i+1) + " CAPTURADO", "CAPTURA DE ALUMNOS", 1);
			
			//Se van sumando todos los promedios para que luego se pueda dividir por la cantidad de alumnos
			promedios = promedios + Arr_Estudiantes[i].getPromedio();
		}
		
		
		//Ciclo que pide los datos del profesor, similar al anterior a excepcion de datos significativos.
		for(int i = 0; i < Profesores; i++)
		{
			Arr_Profesores[i] = new Profesor();
			//Se reciben los datos anteriores que son los que se tienen en comun.
			Arr_Profesores[i].setNombre(JOptionPane.showInputDialog(null, "NOMBRE DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
			Arr_Profesores[i].setCorreo(JOptionPane.showInputDialog(null, "CORREO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
			Arr_Profesores[i].setDireccion(JOptionPane.showInputDialog(null, "DIRECCION DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
			Arr_Profesores[i].setGenero(JOptionPane.showInputDialog(null, "GENERO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
			Arr_Profesores[i].setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "EDAD DEL PROFESOR", "CAPTURA DE PROFESORES", 3)));
			
			//Datos significativos del profesor
			//Se recibe el numero de empleado del profesor
			Arr_Profesores[i].setNumeroEmpleado(Integer.parseInt(JOptionPane.showInputDialog(null, "NUMERO DE EMPLEADO", "CAPTURA DE PROFESORES", 3)));
			
			//Se determina el grado del profesor
			Arr_Profesores[i].setGrado(JOptionPane.showInputDialog(null, "GRADO DEL PROFESOR", "CAPTURA DE PROFESORES", 3));
			
			//Impresion de un mensaje que informa que se logro capturar al alumno.
			JOptionPane.showMessageDialog(null, "PROFESOR " + (i+1) + " CAPTURADO", "CAPTURA DE PROFESORES", 1);
		}
		
		
		//Ciclo para imprimir a todos los alumnos
		for(int i = 0; i < Alumnos; i++)
		{
			JOptionPane.showMessageDialog(null, "ALUMNO: " + (i+1) 
			+ "\nNOMBRE: " + Arr_Estudiantes[i] 
			+ "\nCORREO: " + Arr_Estudiantes[i].getCorreo() 
			+ "\nDIRECCION: " + Arr_Estudiantes[i].getDireccion() 
			+ "\nGENERO: " + Arr_Estudiantes[i].getGenero() 
			+ "\nEDAD: " + Arr_Estudiantes[i].getEdad() 
			+ "\n\nMATRICULA: " + Arr_Estudiantes[i].getMatricula() 
			+ "\nPROMEDIO: " + Arr_Estudiantes[i].getPromedio(), "ALUMNO", 1);
		}
		
		//Impresion del promedio general del grupo
		JOptionPane.showMessageDialog(null, "PROMEDIO GRUPAL: " + (promedios/Alumnos), "PROMEDIO GRUPAL", 1);
		
		//Ciclo para imprimir a todos los profesores
		for(int i = 0; i < Profesores; i++)
		{
			JOptionPane.showMessageDialog(null, "PROFESOR: " + (i+1) 
			+ "\nNOMBRE: " + Arr_Profesores[i] 
			+ "\nCORREO: " + Arr_Profesores[i].getCorreo() 
			+ "\nDIRECCION: " + Arr_Profesores[i].getDireccion() 
			+ "\nGENERO: " + Arr_Profesores[i].getGenero() 
			+ "\nEDAD: " + Arr_Profesores[i].getEdad()
			+ "\n\nNUMERO DE EMPLEADO: " + Arr_Profesores[i].getNumeroEmpelado() 
			+ "\nGRADO: " + Arr_Profesores[i].getGrado(), "PROFESOR", 1);
		}
			
	}
}

//Clase persona
//Contiene elementos y metodos que tienen en comun las personas
class Persona
{
	String Nombre;
	String Correo;
	String Direccion;
	String Genero;
	int Edad;

	//Metodo que determina el nombre de la persona
	public void setNombre(String Nombre)
	{
		this.Nombre = Nombre;
		//Se usa this para referirse a la variable dentro de la clase y no confundir las dos variables del mismo una con la otra.
	}
	
	//Metodo que determina el correo de la persona
	public void setCorreo(String Correo)
	{
		this.Correo = Correo;
	}
	
	//Metodo que determina la direccion de la persona
	public void setDireccion(String Direccion)
	{
		this.Direccion = Direccion;
	}
	
	//Metodo que determina el genero de la persona
	public void setGenero(String Genero)
	{
		this.Genero = Genero;
	}
	
	//Metodo que determina la edad de la persona
	public void setEdad(int Edad)
	{
		this.Edad = Edad;
	}
		
	//get
	//Metodo que regresa el nombre de la persona
	public String toString()
	{
		return Nombre;
	}
	
	//Metodo que regresa el correo de la persona
	public String getCorreo()
	{
		return Correo;
	}
	
	//Metodo que regresa la direccion de la persona
	public String getDireccion()
	{
		return Direccion;
	}
	
	//Metodo que regresa el genero de la persona
	public String getGenero()
	{
		return Genero;
	}
	
	//Metodo que regresa la edad de la persona
	public int getEdad()
	{
		return Edad;
	}

}

//clase estudiante
//Extends persona permite que la clase herede todas las variables y metodos
//de la clase de persona aparte de incluir sus propias.
class Estudiante extends Persona
{
	String Matricula;
	
	float Promedio;
	
	//Metodos de determinacion
	public void setMatricula(String Matricula)
	{
		this.Matricula = Matricula;
	}
	
	public void setPromedio(float Promedio)
	{
		this.Promedio = Promedio;
	}
	
	//Metodos de regreso de datos
	public String getMatricula()
	{
		return Matricula;
	}
	
	public float getPromedio()
	{
		return Promedio;
	}
	
}

//clase profesor
//Similar a la de estudiante, contiene las mismas variables
//y metodos que la de persona, pero es diferente a la de estudiante.
class Profesor extends Persona
{
	int NumeroEmpleado;
	
	String Grado;
	
	//set
	public void setNumeroEmpleado(int NumeroEmpleado)
	{
		this.NumeroEmpleado = NumeroEmpleado;
	}
	
	public void setGrado(String Grado)
	{
		this.Grado = Grado;
	}
	
	//get
	public int getNumeroEmpelado()
	{
		return NumeroEmpleado;
	}
	
	public String getGrado()
	{
		return Grado;
	}
	
}
