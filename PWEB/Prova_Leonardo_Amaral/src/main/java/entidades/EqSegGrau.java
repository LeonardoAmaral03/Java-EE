package entidades;

public class EqSegGrau {
	private double a;
	private double b;
	private double c;
	private double x1;
	private double x2;
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public double calcDelta() {
		double delta;
		delta = Math.pow(b, 2) - 4 * a * c;
		return delta;
	}
	
	public double calcX1() {
		x1 = (-(b) + Math.sqrt(calcDelta())) / (2 * a);
		return x1;
	}
	
	public double calcX2() {
		x2 = (-(b) - Math.sqrt(calcDelta())) / (2 * a);
		return x2;
	}
}
