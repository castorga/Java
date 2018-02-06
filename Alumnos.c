#include <stdio.h>
#include <stdlib.h>

#define CLS(); system("cls"); // medio feo pero sirve por el momento

typedef struct
{
	int 		MATRICULA;
	char 		NOMBRE[41];
	signed char MATERIAS[9];
	float 		CALIFICACIONES[9];
	float		PROMEDIO;
}
ALUMNO;

const char* MATERIA[] = {	"SENALES Y SISTEMAS", 
							"METODOS NUMERICOS",
							"CIRCUITOS DIGITALES", 
							"ELABORACION DE DOCUMENTACION TECNICA", 
							"PROGRAMACION ORIENTADA A OBJETOS", 
							"ELECTRONICA APLICADA", 
							"MATEMATICAS DISCRETAS", 
							"CONTABILIDAD DE COSTOS", 
							"MERCADOTECNIA" };
							
void printline(char mode);								
void MENU();
void REGISTRAR();
void ELIMINAR();
void REVISAR();
void PROMEDIAR();
int BUSQMATRICULA(int matricula);

int main()
{
	short int OPCION;
	do
	{
		CLS();
		MENU();
		printf("\n\nEscoge tu opcion: ");
		scanf("%hd", &OPCION);
		
		switch(OPCION)
		{
			case 1:	REGISTRAR(); break;
			case 2: ELIMINAR(); break;
			case 3: REVISAR(); break;
			case 4: PROMEDIAR(); break;
		}
		
	}while(OPCION != 9);
	return 0;
}

void printline(char mode)
{
	int i;
	if(mode == 0)
	{
		for(i = 0; i < 80; i++)
			printf("%c", 205);
		printf("\n");
	}
	else
	{
		for(i = 0; i < 80; i++)
		{
			if(i == 25)
			{
				printf("     PROMEDIOS DE ALUMNOS     ");
				i = 54;
			}
			else
				printf("%c", 205);
		}
		printf("\n");
	}
}

void MENU()
{
	printline(0);
	printline(1);
	printline(0);
	printf("Seleccione una opcion:\n\n");
	printf("[1] Agregar registro de un alumno\n");
	printf("[2] Eliminar registro de un alumno\n");
	printf("[3] Revisar datos de un alumno\n");
	printf("[4] Calcular promedio general\n\n");
	printf("[9] Salir");
}

void REGISTRAR()
{
	int i;
	int matricula_temp;
	int c = 0;
	float suma = 0;
	short int opc;
	ALUMNO TMP;
	FILE* REGISTRO;
	REGISTRO = fopen("registro.dat", "ab+");
	if(!REGISTRO)
	{
		printf("\n\nHubo un error al momento de abrir/crear el archivo.");
		getchar();
	}
	else
	{
		printf("\n\nCaptura la matricula del alumno:\n");
		scanf("%d", &matricula_temp);
		if(BUSQMATRICULA(matricula_temp) == 0)
			TMP.MATRICULA = matricula_temp;
		else
		{
			do
			{
				printf("\n\nMatricula ya registrada, escriba otra:\n");
				scanf("%d", &matricula_temp);
			}while(BUSQMATRICULA(matricula_temp) == 1);
			TMP.MATRICULA = matricula_temp;
		}
		
		setbuf(stdin, 0);
		printf("\n\nCaptura el nombre del alumno:\n");
		fgets(TMP.NOMBRE, sizeof(TMP.NOMBRE), stdin);
		setbuf(stdin, 0);
		
		printf("\n\nCaptura las materias y calificaciones del alumno.\n");
		for(i = 0; i < 9; i++)
		{
			printf("El alumno lleva la materia de %s?\n[1] - SI\n[0] - NO\n", MATERIA[i]);
			scanf("%hd", &opc);
			if(opc == 0)
			{
				TMP.MATERIAS[i] = -1;
				TMP.CALIFICACIONES[i] = -1;
			}
			else
			{
				TMP.MATERIAS[i] = 1;
				printf("\nIntroduzca la calificacion de esta materia. (Ej: 100, 75, 94): ");
				scanf("%f", &TMP.CALIFICACIONES[i]);
				if(TMP.CALIFICACIONES[i] > 100)
					TMP.CALIFICACIONES[i] = 100;
				if(TMP.CALIFICACIONES[i] < 0)
					TMP.CALIFICACIONES[i] = 0;
				printf("\n\n");
				suma += TMP.CALIFICACIONES[i];
				c++;
			}
		}
		if(c > 0)
			TMP.PROMEDIO = (float)suma/(float)c;
		else
			TMP.PROMEDIO = -1;
		fwrite(&TMP, sizeof(TMP), 1, REGISTRO);
		fclose(REGISTRO);
		CLS();
		printf("REGISTRO GUARDADO.");
		setbuf(stdin, 0);
		getchar();
	}
}

void ELIMINAR()
{
	int response = 0;
	ALUMNO TMP;
	FILE *REGISTRO, *FTMP;
	int matricula;
	printf("\n\nCaptura la matricula del alumno:\n");
	scanf("%d", &matricula);
	REGISTRO = fopen("registro.dat", "rb");
	FTMP = fopen("tmp.dat", "wb");
	if(!FTMP || !REGISTRO)
	{
		printf("\n\nHubo un error al momento de abrir/crear el archivo.");
	}
	else
	{
		while(fread(&TMP, sizeof(ALUMNO), 1, REGISTRO) > 0)
		{
			if(TMP.MATRICULA != matricula)
				fwrite(&TMP, sizeof(ALUMNO), 1, FTMP);
			if(TMP.MATRICULA == matricula)
				response = 1;
		}
		fclose(REGISTRO);
		fclose(FTMP);
		rename("tmp.dat", "registro.dat");
		if(response == 1)
			printf("\n\nListo.");
		else
			printf("El alumno no existe.");
	}
	setbuf(stdin, 0);
	getchar();
}

void REVISAR()
{
	int c = 0;
	int i = 72;
	int matricula;
	ALUMNO TMP;
	FILE* REGISTRO;
	REGISTRO = fopen("registro.dat", "rb");
	if(!REGISTRO)
	{
		printf("\n\nHubo un error al momento de abrir el archivo.");
		getchar();
	}
	else
	{
		printf("\n\nEscribe la matricula del alumno:\n");
		scanf("%d", &matricula);
		while(fread(&TMP, sizeof(TMP), 1, REGISTRO))
		{
			if(matricula == TMP.MATRICULA)
			{
				CLS();
				printf("ALUMNO: %s", TMP.NOMBRE);
				printf("MATRICULA: %d\n", TMP.MATRICULA);
				printf("CALIFICACIONES:\n\n");
				for(i = 0; i < 9; i++)
				{
					if(TMP.MATERIAS[i] == -1)
					{
						// no hacer nada porque no esta cursando la materia
					}
					else
					{
						if(i == 1 || i == 8)
							printf("+[%d] %s \t\t\t\t %2.2f [%d]\n", c+1, MATERIA[i], TMP.CALIFICACIONES[i], c+1);
						else if(i == 3)
							printf("+[%d] %s \t %2.2f [%d]\n", c+1, MATERIA[i], TMP.CALIFICACIONES[i], c+1);
						else if(i == 4)
							printf("+[%d] %s \t\t %2.2f [%d]\n", c+1, MATERIA[i], TMP.CALIFICACIONES[i], c+1);
						else
							printf("+[%d] %s \t\t\t %2.2f [%d]\n", c+1, MATERIA[i], TMP.CALIFICACIONES[i], c+1);
						c++;
					}
				}
				if(c > 0)
					printf("\n\nPROMEDIO GENERAL DEL ALUMNO: %f", TMP.PROMEDIO);
				else
					printf("EL ALUMNO NO ESTA CURSANDO NINGUNA MATERIA POR EL MOMENTO");
			}
		}
		if(i == 72)
			printf("No se pudo localizar al alumno.");
		fclose(REGISTRO);
		setbuf(stdin, 0);
		getchar();
	}
}

void PROMEDIAR()
{
	ALUMNO TMP;
	int c = 0;
	float prom = 0;
	FILE* REGISTRO = fopen("registro.dat", "rb");
	if(!REGISTRO)
	{
		printf("\n\nHubo un error al momento de abrir el archivo.");
		getchar();
	}
	else
	{
		while(fread(&TMP, sizeof(TMP), 1, REGISTRO))
		{
			if(TMP.PROMEDIO != -1)
			{
				c++;
				printf("[%d] ALUMNO: %s    MATRICULA: %d\n    PROMEDIO: %.2f\n\n", c, TMP.NOMBRE, TMP.MATRICULA, TMP.PROMEDIO);
				prom += TMP.PROMEDIO;
			}
		}
		printf("\nPROMEDIO GENERAL DEL GRUPO ES: %.2f", prom/c);
		fclose(REGISTRO);
		setbuf(stdin, 0);
		getchar();
	}
}

int BUSQMATRICULA(int matricula)
{
	ALUMNO TMP;
	FILE* regist;
	regist = fopen("registro.dat", "rb");
	if(!regist)
		return -1;
	else
	{
		while(fread(&TMP, sizeof(TMP), 1, regist))
		{
			if(TMP.MATRICULA == matricula)
				return 1;
		}
		fclose(regist);
	}
	return 0;
}