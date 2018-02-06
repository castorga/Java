//Practica 1
//Modificar el programa de alumnos eliminando el serializado e imprimiendo
//los datos de los alumnos en su propia ventana + el promedio general del grupo.

import javax.swing.*;

public class wtf
{
	public static void main(String args[])
	{
		int i;
		int promedio_grupo = 0;
		int contador = 0;
		int total_alumnos = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema."));
		AlumnoBase tmp = new AlumnoBase();
		Alumno arreglo[] = new Alumno[total_alumnos];
		
		for(i = 0; i < total_alumnos; i++)
		{
			contador = contador + 1;
			
			//arreglo[i] = new Alumno();
			tmp.Nombre = JOptionPane.showInputDialog("Nombre del alumno.");
			tmp.PromedioPOO = Integer.parseInt(JOptionPane.showInputDialog("Promedio POO del alumno."));
			tmp.Direccion = JOptionPane.showInputDialog("Direccion del alumno.");
			tmp.Sexo = JOptionPane.showInputDialog("Sexo del alumno. (Masculino/Femenino)");
			tmp.Telefono = JOptionPane.showInputDialog("Telefono del alumno.");
			
			arreglo[i] = new Alumno(tmp.Nombre, tmp.Telefono, tmp.Direccion, tmp.Sexo, tmp.PromedioPOO);
			
			promedio_grupo += tmp.PromedioPOO;
		}
		
		for(i = 0; i < total_alumnos; i++)
		{
			JOptionPane.showMessageDialog(null, "Nombre: " + arreglo[i] + "\nSexo: " + arreglo[i].getSexo() + "\nDireccion: " + arreglo[i].getDireccion() + "\nTelefono: " + arreglo[i].getTelefono() + "\nPromedio POO: " + arreglo[i].getPromedioPOO());
		}
		
		JOptionPane.showMessageDialog(null, "Promedio grupal de POO: " + promedio_grupo/total_alumnos);
	}
}

class AlumnoBase
{
	String Nombre;
	String Telefono;
	String Direccion;
	String Sexo;
	int PromedioPOO;
}

class Alumno
{
	String Nombre;
	String Telefono;
	String Direccion;
	String Sexo;
	int PromedioPOO;
	
	public Alumno(String CAPTURA_NOMBRE, String CAPTURA_TELEFONO, String CAPTURA_DIRECCION, String CAPTURA_SEXO, int CAPTURA_PROMEDIOPOO)
	{
		Nombre = CAPTURA_NOMBRE;
		Telefono = CAPTURA_TELEFONO;
		Direccion = CAPTURA_DIRECCION;
		Sexo = CAPTURA_SEXO;
		PromedioPOO = CAPTURA_PROMEDIOPOO;
	}
	
	public String toString()
	{
		return Nombre;
	}
	
	public String getTelefono()
	{
		return Telefono;
	}
	
	public String getDireccion()
	{
		return Direccion;
	}
	
	public String getSexo()
	{
		return Sexo;
	}
	
	public int getPromedioPOO()
	{
		return PromedioPOO;
	}
}

