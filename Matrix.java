import javax.swing.*;
import java.util.Random;

public class Matriz{
	static MtxInt Mat_Int;
	static MtxFloat Mat_Flt;
	public static void main(String args[]){
		int rows, cols;
		boolean intr = false;
		boolean fltr = false;
		int answer;
		do{
			try{
			answer = menu();
			} catch(NullPointerException e){
				answer = 4;
			}
			switch(answer){
				case 0: 
					if(intr == false){
						rows = returnNum('r');
						cols = returnNum('c');
						Mat_Int = new MtxInt(rows, cols);
					}
					//Init('c');
					intr = true;
					break;
				case 1: 
					if(fltr == false){
						rows = returnNum('r');
						cols = returnNum('c');
						Mat_Flt = new MtxFloat(rows, cols);
					}
					fltr = true;
					break;
				case 2: 
					if(intr == false)
						JOptionPane.showMessageDialog(null, "NO HAY MATRIZ!!", "MATRIZ", 0);
					else
						ver_Matriz('i');
					break;
				case 3: 
					if(fltr == false)
						JOptionPane.showMessageDialog(null, "NO HAY MATRIZ!!", "MATRIZ", 0);
					else
						ver_Matriz('f');
					break;
				default:
					break;
			}
		}while(answer != 4);
	}
	
	public static int menu(){
		String Options[] = { 	"Inicializar matriz INT", 
							"Inicializar matriz FLOAT", 
							"Ver matriz INT", 
							"Ver matriz FLOAT" };
		String input = 	input = (String) JOptionPane.showInputDialog(	null, 
																		"MATRICES\nSelecciona una opcion.", 
																		"MATRICES",
																		1,
																		null,
																		Options, 
																		Options[0]); 
		if(input.equals(Options[0]))
			return 0;
		else if(input.equals(Options[1]))
			return 1;
		else if(input.equals(Options[2]))
			return 2;
		else if(input.equals(Options[3]))
			return 3;
		else
			return 4;
	}
	
	public static int returnNum(char mode){
		if(mode == 'r')
			return Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de renglones", "MATRIZ", 3));
		else
			return Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de columnas", "MATRIZ", 3));
	}
	
	public static void ver_Matriz(char mode){
		if(mode == 'i'){
			Mat_Int.printMtxIntCon();
			Mat_Int.printMtxIntWindow();
		}
		if(mode == 'f'){
			Mat_Flt.printMtxFloatCon();
			Mat_Flt.printMtxFloatWindow();
		}
	}
}

class Mtx{
	int row;
	int col;
	
	public Mtx(int r, int c){
		row = r;
		col = c;
	}
	
	public int getRows(){
		return row;
	}
	
	public int getCols(){
		return col;
	}
}

class MtxInt extends Mtx{
	int[][] matrix;
	
	public MtxInt(int r, int c){
		super(r, c);
		matrix = new int[r][c];
		InitMtxInt();
	}
	
	public void InitMtxInt(){
		Random rand = new Random();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				matrix[i][j] = rand.nextInt(100);
			}
		}
	}
	
	public void printMtxIntCon(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print("[" + String.format("%02d", matrix[i][j]) + "]");
			}
			System.out.println();
		}
	}
	
	public void printMtxIntWindow(){
		String mtrx = "";
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				mtrx += String.format("[%02d]", matrix[i][j]);
			}
			mtrx += "\n";
		}
		JOptionPane.showMessageDialog(null, mtrx, "Matriz", 1);
	}
}

class MtxFloat extends Mtx{
	float[][] matrix;
	
	public MtxFloat(int r, int c){
		super(r, c);
		matrix = new float[r][c];
		InitMtxFloat();
	}
	
	public void InitMtxFloat(){
		Random rand = new Random();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				matrix[i][j] = (float)rand.nextInt(1000)/10;
			}
		}
	}
	
	public void printMtxFloatCon(){
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(String.format("[%02.2f]", matrix[i][j]));
			}
			System.out.println();
		}
	}
	
	public void printMtxFloatWindow(){
		String mtrx = "";
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				mtrx += String.format("[%02.2f]", matrix[i][j]);
			}
			mtrx += "\n";
		}
		JOptionPane.showMessageDialog(null, mtrx, "Matriz", 1);
	}
}

