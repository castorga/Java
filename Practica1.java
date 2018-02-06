//Practica 1
//Modificar el programa de alumnos eliminando el serializado e imprimiendo
//los datos de los alumnos en su propia ventana + el promedio general del grupo.

import javax.swing.*;

public class Practica1
{
	public static void main(String args[])
	{
		int i;
		int promedio_grupo = 0;
		int contador = 0;
		int total_alumnos = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema."));
		Alumno arreglo[] = new Alumno[total_alumnos];
		
		for(i = 0; i < total_alumnos; i++)
		{
			contador = contador + 1;
			
			arreglo[i] = new Alumno();
			arreglo[i].Nombre = JOptionPane.showInputDialog("Nombre del alumno.");
			arreglo[i].PromedioPOO = Integer.parseInt(JOptionPane.showInputDialog("Promedio POO del alumno."));
			arreglo[i].Direccion = JOptionPane.showInputDialog("Direccion del alumno.");
			arreglo[i].Sexo = JOptionPane.showInputDialog("Sexo del alumno. (Masculino/Femenino)");
			arreglo[i].Telefono = JOptionPane.showInputDialog("Telefono del alumno.");
			
			promedio_grupo += arreglo[i].PromedioPOO;
		}
		
		for(i = 0; i < total_alumnos; i++)
		{
			JOptionPane.showMessageDialog(null, "Nombre: " + arreglo[i].Nombre + "\nSexo: " + arreglo[i].Sexo + "\nDireccion: " + arreglo[i].Direccion + "\nTelefono: " + arreglo[i].Telefono + "\nPromedio POO: " + arreglo[i].PromedioPOO);
		}
		
		JOptionPane.showMessageDialog(null, "Promedio grupal de POO: " + promedio_grupo/total_alumnos);
	}
}

class Alumno
{
	String Nombre;
	String Telefono;
	String Direccion;
	String Sexo;
	int PromedioPOO;
}

