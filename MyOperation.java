/**
 * �������� � Java
 */

import java.util.Random;
import javax.naming.OperationNotSupportedException;

public class MyOperation 
{
	public static void main(String[] args) throws OperationNotSupportedException 
	{
		MyString myStr = new MyString();
		System.out.println(myStr.add("����", "������"));
		
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
 * ���������, ����������� ��������� ��������
**/
interface Operations<T>
{
	/**����� ��� �������� ���� �������� ���� T*/
	public T add(T digitA, T digitB);
	/**
	 * ����� ��� ������� ���� �������� ���� T
	 * @throws OperationNotSupportedException ��������, ���� �������� ����������
	 * */
	public T divide(T digitA, T digitB) throws OperationNotSupportedException;
	/**
	 * ����� ��� ��������� ���� �������� ���� T
	 * @throws OperationNotSupportedException ��������, ���� �������� ����������
	 * */
	public T multiple(T digitA, T digitB) throws OperationNotSupportedException;
	/**����� ��� ��������� ���� �������� ���� T*/
	public T sub(T digitA, T digitB);
} 

/**�����, ���������� ������ ������������ 2�2 
 * � ����������� ��� ���������� ������� 
 * ��� �������� ���������� ������
 * */
class Vector 
{
	/**������, ������������ 2�2*/
	public int vector[][] = new int[2][2];
	/**������������, ��� ���������� ������� ���������� �������*/
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
	 * ����� ��� ������ ������� �� �����
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
	 * ����� �������� 2� ��������
	 * @param digitA ������ �1
	 * @param digitB ������ �2
	 * @return ��������� ������ Vector
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
	 * ����� ������� 2� ��������
	 * @throws OperationNotSupportedException ��������, ���� �������� ����������
	 * */
	@Override
	public Vector divide(Vector digitA, Vector digitB)
			throws OperationNotSupportedException
	{
		throw new OperationNotSupportedException();
	}

	/**
	 * ����� ��������� 2� ��������
	 * @throws OperationNotSupportedException ��������, ���� �������� ����������
	 * */
	@Override
	public Vector multiple(Vector digitA, Vector digitB)
			throws OperationNotSupportedException
	{
		throw new OperationNotSupportedException();
	}
	
	/**
	 * ����� ���������� �������� 2� ��������.
	 * @param digitA ������ �1
	 * @param digitB ������ �2
	 * @return ��������� ������ Vector
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