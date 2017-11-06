package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SomaManagedBean {
   
    private double num1;
    private double num2;
    private double result;
    
 	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
    
    public String somar(){
    	result = num1 + num2;
    	return "";
    }	
    
    public String subtrair(){
    	result = num1 - num2;
    	return "";
    }
	
    public String multiplicar(){
    	result = num1 * num2;
    	return "";
    }
     
    public String dividir(){
    	result = num1 / num2;
    	return "";
    }
}