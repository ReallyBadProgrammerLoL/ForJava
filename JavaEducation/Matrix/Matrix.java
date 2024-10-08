package Matrix;

import java.util.Arrays;

public class Matrix{
	private Integer[][] vaElements;//Хранит значения элементов матрицы
	
	//Конструктор матрицы
	public Matrix(Integer[][] paElements) {
		try {
			findMaxRow(paElements);
			int vRowNum = 0;
			int vRowLength;
			vaElements =  new Integer[paElements.length][];
			for (Integer[] vRow: paElements) {
				
				vRowLength = vRow.length;
				vaElements[vRowNum] = paElements[vRowNum].clone();
				vRowNum += 1;
				
			}
					
			
		} catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		finally{
			System.err.println();
		}	
	}
	
	public Matrix() {
		
	}
	
	private Matrix(int pRowCount, int pColumnCount) {
		this.vaElements = new Integer[pRowCount][pColumnCount];
	}
	
	
	//Метод вывода матрицы
	public void printMatrix() {
		if (this.vaElements != null) {
			
		for(Integer[] vRow: this.vaElements) {
			for(Integer vEl: vRow) {
				System.out.print(vEl + " ");
			}
			System.out.println();
		}}
		else {
			System.out.println("пустая матрица");
		}
	}
	
	public Matrix MultiplyMatrix(Matrix pSecond) {
		Matrix vResult = null;
		
		int vFirstLenColumn = this.vaElements[0].length;
		int vSecondLenRow = pSecond.vaElements.length;
		
		if(this.vaElements != null && pSecond.vaElements != null) {
			if(vFirstLenColumn == vSecondLenRow) {
				int sum = 0;
				vResult = new Matrix(vSecondLenRow, vFirstLenColumn);
				for (int i = 0; i < vSecondLenRow; i++) {
		            for (int j = 0; j < vFirstLenColumn; j++) {
		                for (int k = 0; k < vFirstLenColumn; k++) {
		                	sum+= this.vaElements[i][k] * pSecond.vaElements[k][j];
		                	//System.out.print(this.vaElements[i][k] + "*" + pSecond.vaElements[k][j] + " + ");
		                }
		                vResult.vaElements[i][j] = sum;
		                //System.out.print("=" + sum + '\n');
		                sum = 0;
		            }
				}
				
			}
		}
		return vResult;
	}
	
	public void clone(Matrix clone)
	 {
		this.vaElements = clone.vaElements;
	 }
	//Метод поиска максиальой и обнаружение "неравенства строк"
	private void findMaxRow(Integer[][] paElements) throws Exception  {
		
		int vMax = Integer.MIN_VALUE;
		int vMin = Integer.MAX_VALUE;
		
		for (Integer[] vRow: paElements) {
			if (vMax < vRow.length) {
				vMax = vRow.length;
			}
			if(vMin > vRow.length) {
				vMin = vRow.length;
			}
		}
		
		if (vMax != vMin) {
			throw new Exception("Некорректный ввод матрицы");
		}
	}

}

