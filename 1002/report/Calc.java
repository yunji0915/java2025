package report;

abstract public class Calc {
	protected String errorMsg;
	protected int a, b;
	
	abstract public void setValue(int a, int b);
	abstract public int calculate();
}
