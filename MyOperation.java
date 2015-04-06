/**
 * Генерики в Java
 */

import java.util.Random;
import javax.naming.OperationNotSupportedException;

public class MyOperation 
{
	public static void main(String[] args) throws OperationNotSupportedException 
	{
		MyString myStr = new MyString();
		System.out.println(myStr.add("миро", "творец"));
		
		Vector vectorA = new Vector();
		Vector vectorB = new Vector();
		
		System.out.println("Vector #1:");
		vectorA.printVector();
		
		System.out.println("Vector #2:");
		vectorB.printVector();
		
		System.out.println("Vector #1 + Vector #2:");
		MyVector myVector = new MyVector();
		myVector.add(vectorA, vectorB).printVector();
		System.out.write(1);
	}
}

/**
 * Интерфейс, описывающий доступные операции
**/
interface Operations<T>
{
	/**Метод для сложения двух объектов типа T*/
	public T add(T digitA, T digitB);
	/**
	 * Метод для деления двух объектов типа T
	 * @throws OperationNotSupportedException выдается, если операция недоступна
	 * */
	public T divide(T digitA, T digitB) throws OperationNotSupportedException;
	/**
	 * Метод для умножения двух объектов типа T
	 * @throws OperationNotSupportedException выдается, если операция недоступна
	 * */
	public T multiple(T digitA, T digitB) throws OperationNotSupportedException;
	/**Метод для вычитания двух объектов типа T*/
	public T sub(T digitA, T digitB);
} 


/**Класс, содержащий вектор размерностью 2х2 
 * и заполняющий его случайными числами 
 * при создании экземпляра класса
 * */
class Vector 
{
	/**Вектор, размерностью 2х2*/
	public int vector[][] = new int[2][2];
	/**Рандомизатор, для заполнения вектора случайными числами*/
	Random rnd = new Random();
	
	public Vector()
	{
		for (int i=0; i<2; i++) 
		{
		   for (int j=0; j<2; j++) 
		   {
			   this.vector[i][j] = rnd.nextInt(10);
		   }
		} 
	}
	
	/**
	 * Метод для вывода вектора на экран
	 * */
	public void printVector()
	{
		for (int i=0; i<2; i++) 
		{
		   for (int j=0; j<2; j++) 
		   {
			   System.out.print(this.vector[i][j]+ "\t");
		   }
		   System.out.println();
		} 
	}
}


class MyVector implements Operations<Vector>
{
	/**
	 * Метод сложения 2х векторов
	 * @param digitA вектор №1
	 * @param digitB вектор №2
	 * @return экземпляр класса Vector
	 * */
	@Override
	public Vector add(Vector digitA, Vector digitB)
	{
		Vector result = new Vector();
		for (int i=0; i < digitA.vector.length; i++) 
		{
		   for (int j=0; j < digitB.vector.length; j++) 
			   result.vector[i][j] = digitA.vector[i][j] + digitB.vector[i][j];
		}
		return result;
	}

	/**
	 * Метод деления 2х векторов
	 * @throws OperationNotSupportedException выдается, если операция недоступна
	 * */
	@Override
	public Vector divide(Vector digitA, Vector digitB)
			throws OperationNotSupportedException
	{
		throw new OperationNotSupportedException();
	}

	/**
	 * Метод умножения 2х векторов
	 * @throws OperationNotSupportedException выдается, если операция недоступна
	 * */
	@Override
	public Vector multiple(Vector digitA, Vector digitB)
			throws OperationNotSupportedException
	{
		throw new OperationNotSupportedException();
	}
	
	/**
	 * Метод нахождения разности 2х векторов.
	 * @param digitA вектор №1
	 * @param digitB вектор №2
	 * @return экземпляр класса Vector
	 * */
	@Override
	public Vector sub(Vector digitA, Vector digitB)
	{
		Vector result = new Vector();
		for (int i=0; i < digitA.vector.length; i++) 
		{
		   for (int j=0; j < digitB.vector.length; j++) 
			   result.vector[i][j] = digitA.vector[i][j] - digitB.vector[i][j];
		}
		return result;
	}
}

class MyInt implements Operations<Integer>
{
	@Override
	public Integer add(Integer digitA, Integer digitB) 
	{
		return digitA + digitB;
	}

	@Override
	public Integer divide(Integer digitA, Integer digitB) 
	{
		if (digitB==0) return 0;
		return digitA / digitB;
	}

	@Override
	public Integer multiple(Integer digitA, Integer digitB) 
	{
		return digitA * digitB;
	}

	@Override
	public Integer sub(Integer digitA, Integer digitB) 
	{
		return digitA - digitB;
	}
}

class MyDouble implements Operations<Double>
{
	@Override
	public Double add(Double digitA, Double digitB) 
	{
		return digitA + digitB;
	}

	@Override
	public Double divide(Double digitA, Double digitB) 
	{
		if (digitB==0.0) return 0.0;
		return digitA / digitB;
	}

	@Override
	public Double multiple(Double digitA, Double digitB) 
	{
		return digitA * digitB;
	}

	@Override
	public Double sub(Double digitA, Double digitB) 
	{
		return digitA - digitB;
	}
}

class MyString implements Operations<String>
{

	@Override
	public String add(String digitA, String digitB) 
	{
		return digitA.concat(digitB);
	}

	@Override
	public String divide(String digitA, String digitB) throws OperationNotSupportedException 
	{
		throw new OperationNotSupportedException();
	}

	@Override
	public String multiple(String digitA, String digitB) throws OperationNotSupportedException 
	{
		throw new OperationNotSupportedException();
	}

	@Override
	public String sub(String digitA, String digitB) 
	{
		return digitA.replaceAll(digitB, "");
	}
}