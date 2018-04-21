package pkgTriangulo;

public class Triangulo {
	
	private double lado1;
	private double lado2;
	private double lado3;
	
	public double getLado1() {
		return lado1;
	}
	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}
	public double getLado2() {
		return lado2;
	}
	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
	public double getLado3() {
		return lado3;
	}
	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	public boolean isTriangulo() {
		if(lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
			return true;
		}
		return false;
	}
	
	public Triangulo(double lado1,double lado2,double lado3) {
		setLado1(lado1);
		setLado2(lado2);
		setLado3(lado3);
	}
	
	public Triangulo() {
		// TODO Auto-generated constructor stub
	}
	
	public String type() {
		if (lado1 == lado2) {
			if (lado1 == lado3) {
				return ("Es un triangulo equilatero");						
			} else {
				return ("Es un triangulo isosceles");
			}
		} else if (lado1 == lado3 || lado2 == lado3) {
			return ("Es un triangulo isosceles");					
		} else {
			return ("Es un triangulo escaleno");
		}
	}
}
